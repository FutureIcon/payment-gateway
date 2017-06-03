package com.future.payment.persistence.modeling;

import java.util.List;

//@UserDefinedType("SalesOrder")
public class SaleOrder {
	
	private String orderId;
	
	/*@CassandraType(type = Name.LIST,  typeArguments=Name.UDT, userTypeName="OrderItem")*/
	private List<OrderItem> items;
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public List<OrderItem> getItems() {
		return items;
	}
	
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return String.format("SaleOrder[orderId='%s', items='%s']", this.orderId, this.items);
	}
}
