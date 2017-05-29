package com.future.web.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.future.payment.model.BasePaymentResponse;
import com.future.payment.model.PaymentRequest;
import com.future.payment.model.PaymentResponse;
import com.future.web.dto.CheckoutRequest;
import com.future.web.dto.CheckoutResponse;
import com.future.web.dto.Message;
import com.future.web.dto.MessageAcknowledgement;
import com.future.web.service.PaymentServiceClient;
import com.google.common.collect.Maps;

@Service("ribbonPaymentServiceClient")
public class PaymentServiceClientImpl implements PaymentServiceClient {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	private static final String SERVICE_URL = "http://payment-service/";

	@Override
	public MessageAcknowledgement sendMessage(Message message) {
		HttpEntity<Message> requestEntity = new HttpEntity<>(message);
		ResponseEntity<MessageAcknowledgement> response = this.restTemplate.exchange(SERVICE_URL + "message", HttpMethod.POST, requestEntity, MessageAcknowledgement.class, Maps.newHashMap());
		return response.getBody();
	}

	@Override
	public CheckoutResponse checkout(CheckoutRequest request) {
		PaymentRequest serviceRequest = new PaymentRequest();
		serviceRequest.setAmount(new BigDecimal(request.getTotalFee()));
		HttpEntity<PaymentRequest> requestEntity = new HttpEntity<>(serviceRequest);
		ResponseEntity<BasePaymentResponse> response = this.restTemplate.exchange(SERVICE_URL + "payment", HttpMethod.POST, requestEntity, BasePaymentResponse.class, Maps.newHashMap());

		CheckoutResponse checkoutResponse = new CheckoutResponse();
		checkoutResponse.setResultCode(String.valueOf(response.getStatusCode()));
		checkoutResponse.setMessage(response.getBody().getMessage());

		return checkoutResponse;
	}

	@Override
	public CheckoutResponse getCodeUrl(CheckoutRequest request) {
		PaymentRequest serviceRequest = new PaymentRequest();
		serviceRequest.setOrderNumber(request.getTradeNo());
		HttpEntity<PaymentRequest> requestEntity = new HttpEntity<>(serviceRequest);
		ResponseEntity<String> response = this.restTemplate.exchange(SERVICE_URL + "qrcodeurl", HttpMethod.POST, requestEntity, String.class);
		CheckoutResponse checkoutResponse = new CheckoutResponse();
		checkoutResponse.setCodeUrl(response.getBody());
		return checkoutResponse;
	}

	@Override
	public CheckoutResponse getOrderStatus(CheckoutRequest request) {
		PaymentRequest serviceRequest = new PaymentRequest();
		serviceRequest.setOrderNumber(request.getTradeNo());
		HttpEntity<PaymentRequest> requestEntity = new HttpEntity<>(serviceRequest);
		ResponseEntity<PaymentResponse> response = this.restTemplate.exchange(SERVICE_URL + "payment/" + request.getTradeNo(), HttpMethod.GET, requestEntity, PaymentResponse.class);
		CheckoutResponse checkoutResponse = new CheckoutResponse();
		checkoutResponse.setOrderStatus(response.getBody().getTrade_state());
		return checkoutResponse;
	}
}
