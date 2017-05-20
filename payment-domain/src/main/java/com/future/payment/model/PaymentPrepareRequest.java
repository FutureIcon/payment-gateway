package com.future.payment.model;


public class PaymentPrepareRequest extends BasePaymentRequest{

	private String businessType;
	
	private String clientSubAccount;

	//private Order order;
	
	/*private Customer customer;
	
	private ShippingInfo shippingInfo;
	
	private DeviceInfo deviceInfo;
	
	private PaymentMethod paymentMethod;*/

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getClientSubAccount() {
		return clientSubAccount;
	}

	public void setClientSubAccount(String clientSubAccount) {
		this.clientSubAccount = clientSubAccount;
	}

	/*public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}*/

	/*public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
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
	}*/


}