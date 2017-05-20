package com.future.payment.service;

import com.future.payment.model.PaymentRequest;
import com.future.payment.model.PaymentResponse;
import com.future.payment.model.RefundRequest;
import com.future.payment.model.RefundResponse;

public interface PaymentService {
	
	public PaymentResponse payment(PaymentRequest request);
	
	public String getCodeUrl(PaymentRequest request);
	
	public PaymentResponse getPayment(PaymentRequest request);
	
	public RefundResponse refund(RefundRequest request);

	public PaymentResponse orderQuery(PaymentRequest request);

}
