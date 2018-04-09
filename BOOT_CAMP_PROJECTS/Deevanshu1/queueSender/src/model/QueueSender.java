package model;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicPublisher;
import javax.naming.Context;
import javax.naming.InitialContext;


@SuppressWarnings("unused")
public class QueueSender {

	
	public static void main(String[] args) 
	{
		
		Context ic = null;
		ConnectionFactory cf = null;
		Connection connection = null;
		try {
			ic = new InitialContext();
			cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");
			Queue queue = (Queue) ic.lookup("queue/trainingQueue");
			connection = cf.createConnection();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			TextMessage message=session.createTextMessage();
			message.setText(args[0]);
			MessageProducer sender = session.createProducer(queue);
	
			sender.send(message); 
			System.out.println("The message was successfully sent to the " 
					+ queue.getQueueName() + " queue");

	
			connection.close();	

		} 
		
			catch (Exception e) 
			{
				
			e.printStackTrace();
			}

	}

}
