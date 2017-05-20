package com.future.payment.enums;

public enum TradeState {
	SUCCESS("支付成功"),
	REFUND("转入退款"),
	NOTPAY("未支付"),
	CLOSED("已关闭"),
	REVOKED("已撤销（刷卡支付）"),
	USERPAYING("用户支付中"),
	PAYERROR("支付失败(其他原因，如银行返回失败)");
	
	private String message;
	
	private TradeState (String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
