package com.future.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.future.web.dto.CheckoutRequest;
import com.future.web.dto.CheckoutResponse;
import com.future.web.dto.Message;
import com.future.web.dto.MessageAcknowledgement;
import com.future.web.service.PaymentServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("hystrixPaymentServiceClient")
public class HystrixPaymentServiceClient implements PaymentServiceClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixPaymentServiceClient.class);

	@Autowired
	@Qualifier("ribbonPaymentServiceClient")
	private PaymentServiceClient client;

	@Override
	@HystrixCommand(commandKey = "paymentServiceCommand", groupKey = "paymentServiceGroup", fallbackMethod = "fallBackCall")
	public MessageAcknowledgement sendMessage(Message message) {
		return this.client.sendMessage(message);
	}

	public MessageAcknowledgement fallBackCall(Message message, Throwable e) {
		LOGGER.error("In fallback: ", e);
		MessageAcknowledgement fallback = new MessageAcknowledgement(message.getId(), message.getPayload(), "FAILED SERVICE CALL! - FALLING BACK");
		return fallback;
	}

	@Override
	@HystrixCommand(commandKey = "paymentServiceCommand", groupKey = "paymentServiceGroup", fallbackMethod = "fallBackCall")
	public CheckoutResponse checkout(CheckoutRequest request) {
		return null;
	}

	public CheckoutResponse fallBackCall(CheckoutRequest request, Throwable e) {
		LOGGER.error("In fallback: ", e);
		CheckoutResponse fallback = new CheckoutResponse();
		fallback.setResultCode("0");
		fallback.setMessage("FAILED SERVICE CALL! - FALLING BACK");
		return fallback;
	}

	@Override
	@HystrixCommand(commandKey = "paymentServiceCommand", groupKey = "paymentServiceGroup", fallbackMethod = "fallBackCall")
	public CheckoutResponse getCodeUrl(CheckoutRequest request) {
		return client.getCodeUrl(request);
	}
	
	@Override
	@HystrixCommand(commandKey = "paymentServiceCommand", groupKey = "paymentServiceGroup")
	public CheckoutResponse getOrderStatus(CheckoutRequest request) {
		CheckoutResponse reponse = client.getOrderStatus(request);
		return reponse;
	}
}
