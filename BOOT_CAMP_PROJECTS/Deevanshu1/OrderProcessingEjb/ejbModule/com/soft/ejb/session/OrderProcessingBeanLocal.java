package com.soft.ejb.session;

import javax.ejb.Local;
import com.soft.order.Order;

@Local
public interface OrderProcessingBeanLocal 
{
	public String placeOrder(Order order);

}
