package com.future.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.future.web.dto.CheckoutRequest;
import com.future.web.dto.CheckoutResponse;
import com.future.web.dto.Message;
import com.future.web.dto.MessageAcknowledgement;
import com.future.web.service.PaymentServiceClient;

@RestController
public class CheckoutController {

	@Autowired
	@Qualifier("hystrixPaymentServiceClient")
	private PaymentServiceClient paymentServiceClient;

	@RequestMapping("/test")
	public String sendMessage() {
		return "testing" + getOutTradeNo();
	}
	
	@RequestMapping("/dispatch")
	public MessageAcknowledgement sendMessage(@RequestBody Message message) {
		return this.paymentServiceClient.sendMessage(message);
	}

	@RequestMapping("/checkout")
	public CheckoutResponse checkout(@Valid @RequestBody CheckoutRequest request) {
		CheckoutResponse response = paymentServiceClient.checkout(request);
		return response;
	}

	@RequestMapping("/qrcodeurl")
	public CheckoutResponse qrcodeurl(String totalFee) {
		String tradeNo = getOutTradeNo();
		CheckoutRequest request = new CheckoutRequest();
		request.setTradeNo(tradeNo);
		CheckoutResponse response = paymentServiceClient.getCodeUrl(request);
		response.setOrderNo(tradeNo);
		return response;
	}

	@RequestMapping("/order/{orderNo}")
	public CheckoutResponse orderStatus(@PathVariable String orderNo) {
		CheckoutRequest request = new CheckoutRequest();
		request.setTradeNo(orderNo);
		CheckoutResponse response = paymentServiceClient.getOrderStatus(request);
		response.setOrderStatus(response.getOrderStatus());
		return response;
	}

	private String getOutTradeNo() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))
				+ ThreadLocalRandom.current().nextLong(1000000);
	}
}
