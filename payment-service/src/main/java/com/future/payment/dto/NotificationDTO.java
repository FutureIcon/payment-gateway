package com.future.payment.dto;

import java.util.Date;


public class NotificationDTO extends PayTransactionDTO {
  
    private String internalStatus;
    private String paymentStatus;
    
    private Date payDate;

	@Override
	public PayTransactionDTO createInstance() {		
		return null;
	}

	public String getInternalStatus() {
		return internalStatus;
	}

	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	

}
