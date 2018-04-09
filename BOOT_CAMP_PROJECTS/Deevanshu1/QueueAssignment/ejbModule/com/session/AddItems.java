package com.session;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;

import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;

import com.items.Items;


@Stateless
public class AddItems implements AddItemsRemote, AddItemsLocal {

    
    public AddItems() 
    {
       
    }




	@Override
	public int addItem(Items item) 
	{
		Context ic=null;
		ConnectionFactory cf=null;
		Connection connection;
		try
		{
			ic=new InitialContext();
			cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");
			Queue queue=(Queue)ic.lookup("queue/MessageQueue");
			connection = cf.createConnection();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			ObjectMessage object = session.createObjectMessage(item);
			MessageProducer sender=session.createProducer(queue);
			sender.send(object);
			System.out.println("The message was successfully sent to the " + queue.getQueueName() + " queue");

			connection.close();	
			return 1;
		
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		
		return 1;
	}
	

}
