package com.future.payment.model;

public enum TransactionType {
	
	DoPay("pay"),
	PayDoRefund("refund"),
	PayDoCredit("credit"),
	PayNotification("notification"),
	PayGetBalance("gbal"),
	PayGetMethods("pgm"),
	PayAddBalance("abal"),
	CashOut("cashout");
	
	private String logTrnxType;
	
	TransactionType(String logTrnxType) {
		this.logTrnxType = logTrnxType;
	}
	
	public String getLogTrnxType() {
		return logTrnxType;
	}
	
}
