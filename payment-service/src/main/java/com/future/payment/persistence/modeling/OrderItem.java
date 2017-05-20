package com.future.payment.persistence.modeling;

import java.math.BigDecimal;

import org.springframework.data.cassandra.mapping.UserDefinedType;

//@UserDefinedType("OrderItem")
public class OrderItem {

	private String itemId;
	private String itemTitle;
	private int quantity;
	private BigDecimal price;
	
	public OrderItem(String itemId, String itemTitle, int quantity, BigDecimal price) {
		this.itemId = itemId;
		this.itemTitle = itemTitle;
		this.quantity = quantity;
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("OrderItem[itemId='%s', itemTitle='%s', quantity='%s', price='%s']", this.itemId, this.itemTitle, this.quantity, this.price);
	}
}