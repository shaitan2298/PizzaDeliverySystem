package com.cg.pizza.beans;

import java.util.HashMap;

public class Order 
{
	private int orderId;
	private int quantity;
	private int totalPrice;
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public HashMap<Integer,Integer> items = new HashMap<Integer, Integer>();

	public Order()
	{
		items.put(1,90);
		items.put(2, 110);
		items.put(3,190);
		items.put(4,220);
	}

	/*
	 * public Order(int quantity, HashMap<String, Integer> items) { super();
	 * this.quantity = quantity; this.items = items; }
	 * 
	 * 
	 * public Order(int orderId, int quantity, HashMap<String, Integer> items) {
	 * super(); this.orderId = orderId; this.quantity = quantity; this.items =
	 * items; }
	 */

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public HashMap<Integer, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<Integer, Integer> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", totalPrice=" + totalPrice +  "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + orderId;
		result = prime * result + quantity;
		result = prime * result + totalPrice;
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
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderId != other.orderId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}

	public Order(int orderId, int quantity, int totalPrice, HashMap<Integer, Integer> items) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.items = items;
	}



}
