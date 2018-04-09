package model;

import java.util.ArrayList;
import java.util.Date;

public class OrderClass 
{
	int orderId;
	ArrayList<ItemClass> orderCart=new ArrayList<ItemClass>();
	Date OrderDate=new Date();
	{
	OrderDate.getDate();
	}
	
	
 public OrderClass(int orderId, Date orderDate,ArrayList<ItemClass> orderCart) 
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

	public ArrayList<ItemClass> getAl() {
		return orderCart;
	}

	public void setAl(ArrayList<ItemClass> al) {
		this.orderCart= orderCart;
	}
	
	
	
	
	
	
}
