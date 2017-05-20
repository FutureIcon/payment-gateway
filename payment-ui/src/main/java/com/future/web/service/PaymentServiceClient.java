package com.future.web.service;

import com.future.web.dto.CheckoutRequest;
import com.future.web.dto.CheckoutResponse;
import com.future.web.dto.Message;
import com.future.web.dto.MessageAcknowledgement;

public interface PaymentServiceClient {

	MessageAcknowledgement sendMessage(Message message);

	CheckoutResponse checkout(CheckoutRequest request);

	CheckoutResponse getCodeUrl(CheckoutRequest request);
	
	CheckoutResponse getOrderStatus(CheckoutRequest request);
}