package com.future.payment.persistence.modeling;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

//@PrimaryKeyClass
public class PaymentRequestKey implements Serializable {

	@PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	public PaymentRequestKey(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("PaymentRequestKey[id='%s']", this.id);
	}
}
