package com.topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: Topic2
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "topic/demoTopic")
		}, 
		mappedName = "topic/demoTopic")
public class Topic2 implements MessageListener {

   
    public Topic2() 
    {
        
    }
	
	
    public void onMessage(Message message) 
    {
    	 System.out.println("Topic 2 is Initialized");
        
    }

}
