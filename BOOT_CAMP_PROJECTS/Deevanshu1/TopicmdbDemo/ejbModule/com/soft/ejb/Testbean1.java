package com.soft.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"), 
				@ActivationConfigProperty(
				propertyName = "destination", propertyValue = "topic/testTopic")
		}, 
		mappedName = "topic/testTopic")
public class Testbean1 implements MessageListener 
{

    public Testbean1() 
    {
       
    }
	
    public void onMessage(Message message) 
    {
        System.out.println("Bean 1 Got text Message");
        
    }

}
