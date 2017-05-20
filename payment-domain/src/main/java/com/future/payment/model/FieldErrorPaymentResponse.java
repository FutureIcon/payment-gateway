package com.future.payment.model;

import java.util.ArrayList;
import java.util.List;

import com.future.payment.enums.PaymentResult;

public class FieldErrorPaymentResponse extends BasePaymentResponse {

	private List<FieldError> fieldErrors;

	public FieldErrorPaymentResponse(PaymentResult result) {
		super(result);
	}

	public void addFieldError(FieldError fieldError) {
		if (fieldErrors == null) {
			fieldErrors = new ArrayList<FieldError>();
		}
		fieldErrors.add(fieldError);
	}
}