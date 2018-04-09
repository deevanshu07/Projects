package com.soft.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: Test2bean
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "topic/testTopic")
		}, 
		mappedName = "topic/testTopic")
public class Test2bean implements MessageListener {

    /**
     * Default constructor. 
     */
    public Test2bean() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        System.out.println("Bean2 get Message");
        
    }

}
