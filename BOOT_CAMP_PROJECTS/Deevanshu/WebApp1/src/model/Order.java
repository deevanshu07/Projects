package model;

import java.util.ArrayList;
import java.util.Date;

import org.apache.bcel.generic.D2F;

import Deevanhu.itemClass;


public class Order {
	private int orderId;
	
	ArrayList<itemClass> order_type= new ArrayList<>();

	Date orderdate = new Date();

	public Order(int orderId, Date orderdate) {
		super();
		this.orderId = orderId;
		this.orderdate = orderdate;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Employee [orderId=" + orderId + ", orderdate=" + orderdate
				+ "]";
	}

}