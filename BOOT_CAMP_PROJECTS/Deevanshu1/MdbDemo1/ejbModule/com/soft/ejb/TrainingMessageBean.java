package com.soft.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: TrainingMessageBean
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
@ActivationConfigProperty(
propertyName = "destination", propertyValue = "queue/trainingQueue")
		}, 
		mappedName = "queue/trainingQueue")
public class TrainingMessageBean implements MessageListener {

    /**
     * Default constructor. 
     */
    public TrainingMessageBean() {
        // TODO Auto-generated constructor stub
    }
	
    @PostConstruct
	public void init()
	{
		System.out.println("init method is called before queue");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("this method is destroying the queue");
	}
    public void onMessage(Message message) 
    {
    	
    	try 
    	{
    		TextMessage msg=(TextMessage)message;
			System.out.println(msg.getText());
		} 
    	catch (JMSException e) 
    	{
			
			e.printStackTrace();
		}
      
        
    }

}
