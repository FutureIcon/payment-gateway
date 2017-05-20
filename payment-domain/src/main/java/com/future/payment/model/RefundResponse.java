package com.future.payment.model;

import com.future.payment.enums.PaymentResult;

public class RefundResponse extends BasePaymentResponse{
	

	public RefundResponse(PaymentResult result) {
		super(result);
	}

}
