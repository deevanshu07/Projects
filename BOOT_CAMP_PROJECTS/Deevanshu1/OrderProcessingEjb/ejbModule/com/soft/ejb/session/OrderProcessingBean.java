package com.soft.ejb.session;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.soft.order.Order;

@Stateless
public class OrderProcessingBean implements OrderProcessingBeanRemote, OrderProcessingBeanLocal {

  
    public OrderProcessingBean() 
    {
       
    }

	@Override
	public String placeOrder(Order order) 
	{

		Context ic = null;
		ConnectionFactory cf = null;
		Connection connection = null;
		try {
			ic = new InitialContext();
			cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");
			Queue queue = (Queue) ic.lookup("queue/orderQueue");
			connection = cf.createConnection();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			ObjectMessage message=session.createObjectMessage(order);
			MessageProducer sender = session.createProducer(queue);
	
			sender.send(message); 
			System.out.println("The message was successfully sent to the " 
					+ queue.getQueueName() + " queue");

			connection.close();	
			return ""+queue.getQueueName()+"";
			

		} 
		
			catch (Exception e) 
			{
				
			e.printStackTrace();
			}
		return "not updated";
		
	}

}
