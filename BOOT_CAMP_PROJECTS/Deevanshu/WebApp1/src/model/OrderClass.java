package model;

import java.util.ArrayList;
import java.util.Date;

import Deevanhu.itemClass;

public class OrderClass 
{
	int orderId;
	ArrayList<itemClass> orderCart=new ArrayList<itemClass>();
	Date OrderDate=new Date();
	{
	OrderDate.getDate();
	}
	
	
 public OrderClass(int orderId, Date orderDate,ArrayList<itemClass> orderCart) 
{
		super();
		this.orderId = orderId;
		OrderDate = orderDate;
		
		this.orderCart = orderCart;
	}

	
		
	
	public String toString() 
	{
		return "orderId=" + orderId + ", OrderDate=" + OrderDate
				+ ", orderCart=" + orderCart + "]";
	}

		
		
		


	
	
	public int getOrderId() {
		return orderId;
	}

	public  void setOrderId(int orderId) {
		orderId = orderId;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public ArrayList<itemClass> getAl() {
		return orderCart;
	}

	public void setAl(ArrayList<itemClass> al) {
		this.orderCart= orderCart;
	}
	
	
	
	
	
	
}
