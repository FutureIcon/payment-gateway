package com.future.payment.persistence.modeling;

//@UserDefinedType("DeviceInfo")
public class DeviceInfo {

	private String storeNo;
	private String deviceNo;

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	@Override
	public String toString() {
		return String.format("DeviceInfo[storeNo='%s', deviceNo='%s']", this.storeNo, this.deviceNo);
	}
}
