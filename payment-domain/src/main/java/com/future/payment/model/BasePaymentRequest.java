package com.future.payment.model;

import java.math.BigDecimal;

/**
 * The Class BasePaymentResponse.
 */
public class BasePaymentRequest {


	private String clientReqId;
	
	private BigDecimal amount;

    private String orderNumber;

	public String getClientReqId() {
		return clientReqId;
	}

	public void setClientReqId(String clientReqId) {
		this.clientReqId = clientReqId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
    
    
    

}
