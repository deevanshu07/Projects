package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class queueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public queueServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();
		Context ic =null;
		ConnectionFactory cf=null;
		Connection connection=null;
		try 
		{
			ic= new InitialContext();
			pw.println("Initialized with bean");
			cf=(ConnectionFactory)ic.lookup("/ConnectionFactory");
			Queue queue = (Queue) ic.lookup("queue/demoQueue");
			connection = cf.createConnection();
			Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			TextMessage message=session.createTextMessage();
			message.setText("This is Servlet Queue Message Bean");
			MessageProducer sender = session.createProducer(queue);
	
			sender.send(message); 
			pw.println("The message was successfully sent to the " 
					+ queue.getQueueName() + " queue");

	
			connection.close();	
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
