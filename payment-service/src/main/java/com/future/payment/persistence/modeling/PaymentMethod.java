package com.future.payment.persistence.modeling;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.UserDefinedType;

//@UserDefinedType("PaymentMethod")
public class PaymentMethod {

	private String type;
    private String externalKey;
    private String accountId;
    
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getExternalKey() {
		return externalKey;
	}
	
	public void setExternalKey(String externalKey) {
		this.externalKey = externalKey;
	}
	
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public String toString() {
		return String.format("PaymentMethod[type='%s', externalKey='%s', externalKey='%s']", this.type, this.externalKey, this.externalKey);
	}
}
