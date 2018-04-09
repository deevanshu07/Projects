package com.soft.ejb.session;

import javax.ejb.Remote;

import com.soft.order.Order;

@Remote
public interface OrderProcessingBeanRemote 
{
	public String placeOrder(Order order);

}
