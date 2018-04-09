package model;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;


@SuppressWarnings("unused")
public class TopicPublisher {

	
	public static void main(String[] args) 
	{
		
		Context ic = null;
		ConnectionFactory cf = null;
		Connection connection = null;
	try 
		{
			ic = new InitialContext();
			cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");
			Topic topic = (Topic) ic.lookup("topic/testTopic");
			connection = cf.createConnection();
			TopicSession session=(TopicSession)connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			TextMessage message=session.createTextMessage();
			message.setText(args[0]);
			javax.jms.TopicPublisher pub =session.createPublisher(topic);
			pub.publish(message);
			System.out.println("Deevanshu.....");
			
			System.out.println("The message was successfully sent to the " 
					+ topic.getTopicName() + " queue");

	
			connection.close();	

		} 
		
		catch (Exception e) 
		{
				
		e.printStackTrace();
		}

	}

	private void send(TextMessage message) {
		// TODO Auto-generated method stub
		
	}

}
