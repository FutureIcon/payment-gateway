package com.future.web.dto;

public class CheckoutRequest {

	private String billNo;

	private String title;

	/* @NotNull */
	private String totalFee;

	private String optional;

	private String channel;

	private String tradeNo;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billNo == null) ? 0 : billNo.hashCode());
		result = prime * result + ((optional == null) ? 0 : optional.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((totalFee == null) ? 0 : totalFee.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckoutRequest other = (CheckoutRequest) obj;
		if (billNo == null) {
			if (other.billNo != null)
				return false;
		} else if (!billNo.equals(other.billNo))
			return false;
		if (optional == null) {
			if (other.optional != null)
				return false;
		} else if (!optional.equals(other.optional))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (totalFee == null) {
			if (other.totalFee != null)
				return false;
		} else if (!totalFee.equals(other.totalFee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckoutRequest [billNo=" + billNo + ", title=" + title + ", totalFee=" + totalFee + ", optional="
				+ optional + "]";
	}
}