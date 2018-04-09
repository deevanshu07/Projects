package com.message;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.sql.DataSource;

import com.items.Items;


/**
 * Message-Driven Bean implementation class for: QueuemessageBean
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "queue/MessageQueue")
		}, 
		mappedName = "queue/MessageQueue")

public class QueuemessageBean implements MessageListener 
{
	
	@Resource(mappedName="java:OracleDS")
    DataSource ds;
    public QueuemessageBean() 
    {
       
    }
	
	
    public void onMessage(Message message) 
    {
    	ObjectMessage msg=(ObjectMessage)message;
    	
    	try
    	{
    		Items item= new Items();
    		int id=item.getItemId();
    		String name=item.getItemName();
    		Connection con=ds.getConnection();
    		PreparedStatement psmt=con.prepareStatement("insert into item07 values(?,?)");
 			psmt.setInt(1,id);
 			psmt.setString(2,name);
 			psmt.executeUpdate();
 			System.out.println("Updated");
 			con.close();
    	}
    	catch(Exception e)
    	{
    		
    	}
    	
        
    }

}
