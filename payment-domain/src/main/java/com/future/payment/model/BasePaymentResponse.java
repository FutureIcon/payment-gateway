package com.future.payment.model;

import com.future.payment.enums.PaymentResult;

public class BasePaymentResponse {

	private String result;

	protected int httpStatus;
	protected String code;
	protected String message;

	public BasePaymentResponse() {
		super();
	}

	public BasePaymentResponse(PaymentResult result) {
		code = result.getCode();
		message = result.getMessage();
	}

	public void setCodeAndMessage(PaymentResult result) {
		code = result.getCode();
		message = result.getMessage();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}
}