package com.future.payment.model;

public class PaymentRequest extends PaymentPrepareRequest {
	
	//@NotNull
	private String paymentId;

	//@NotNull
	// @Pattern(regexp = "^U[A-Z]{1}[0-9]{4}$")
	private String authCode;

	// 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
	private String body;

	// 支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
	private String attach;

	// 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
	private String putTradeNo;

	// 订单总金额，单位为“分”，只能整数
	private String totalFee;

	// 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
	private String deviceId;

	// 订单生成的机器IP
	private String spBillCreateIP;

	// 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
	private String timeStart;

	// 订单失效时间，格式同上
	private String timeExpire;

	// 商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
	private String goodsTag;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getPutTradeNo() {
		return putTradeNo;
	}

	public void setPutTradeNo(String putTradeNo) {
		this.putTradeNo = putTradeNo;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSpBillCreateIP() {
		return spBillCreateIP;
	}

	public void setSpBillCreateIP(String spBillCreateIP) {
		this.spBillCreateIP = spBillCreateIP;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}
}