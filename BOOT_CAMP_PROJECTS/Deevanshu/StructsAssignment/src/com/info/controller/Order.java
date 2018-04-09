package com.info.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Order 
{
	private int orderId;
	Date orderdate ;
	public static ArrayList<Item> order= new ArrayList<>();
	
	public static ArrayList<Item> getOrder() 
	{
		return order;
	}
	 public static void setOrder(ArrayList<Item> order) 
	 {
		Order.order = order;
	}
	

	 public Order()
	 {
		 this.orderId=orderId;
		 orderId++;
		 this.orderdate=new Date();
	 }
	 
 public Date getOrderdate() 
 {
	return orderdate;
}
	
 public int getOrderId() 
{
			return orderId;
}

	public void setOrderdate(Date orderdate) 
	{
		this.orderdate = orderdate;
	}
	
	public void setOrderId(int orderId) 
	{
		this.orderId = orderId;
	}
	@Override
public String toString() 
	{
	return "Order [orderId=" + orderId + ", orderdate=" + orderdate + "]";
}
	
	
}
