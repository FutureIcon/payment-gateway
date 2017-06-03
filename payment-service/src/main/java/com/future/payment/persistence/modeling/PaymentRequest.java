package com.future.payment.persistence.modeling;

//@Table(value = "payment_request")
public class PaymentRequest {

	/*@PrimaryKey*/
	private PaymentRequestKey requestKey;
	
	private DeviceInfo deviceInfo;
	
	private PaymentMethod paymentMethod;
	
	private SaleOrder saleOrder;

	public PaymentRequestKey getRequestKey() {
		return requestKey;
	}

	public void setRequestKey(PaymentRequestKey requestKey) {
		this.requestKey = requestKey;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder order) {
		this.saleOrder = order;
	}

	@Override
	public String toString() {
		return String.format("PaymentRequest[requestKey='%s', deviceInfo='%s', paymentMethod='%s', saleOrder='%s']", this.requestKey, this.deviceInfo, this.paymentMethod, this.saleOrder);
	}
	
}
