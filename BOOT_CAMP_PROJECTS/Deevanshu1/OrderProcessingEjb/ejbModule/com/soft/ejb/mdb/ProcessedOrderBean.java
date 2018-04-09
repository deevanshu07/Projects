package com.soft.ejb.mdb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.sql.DataSource;

import com.soft.order.Order;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "queue/orderQueue")
		}, 
		mappedName = "queue/orderQueue")
public class ProcessedOrderBean implements MessageListener {

	@Resource(mappedName="java:OracleDS")
    DataSource ds;
    public ProcessedOrderBean() 
    {
        
    }
	
    
	public void onMessage(Message message) 
    {
        ObjectMessage msg=(ObjectMessage)message;
        try 
        {
        	
			Order order=(Order)msg.getObject();
			String otype=order.getOrderType();
			String odate=order.getOrderDate();
			String oamount=order.getOrderAmount();
			Connection con=ds.getConnection();
			PreparedStatement psmt=con.prepareStatement("insert into my_order values(?,?,?)");
			psmt.setString(1,otype);
			psmt.setString(2,odate);
			psmt.setString(3,oamount);
			psmt.executeUpdate();
			System.out.println("Order Updated");
		} 
        catch (Exception e) 
        {
			
			e.printStackTrace();
		}
        
    }

}
