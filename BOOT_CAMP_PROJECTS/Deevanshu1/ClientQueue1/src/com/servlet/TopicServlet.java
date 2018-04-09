package com.servlet;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopicServlet
 */
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Context ic;
		ConnectionFactory cf=null;
		Connection connection=null;
		try 
		{
			ic= new InitialContext();
			cf=(ConnectionFactory)ic.lookup("/ConnectionFactory");
			Topic topic=(Topic)ic.lookup("topic/demoTopic");
			connection=cf.createConnection();
			TopicSession session=(TopicSession) connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			TextMessage message=session.createTextMessage();
			message.setText("Deevanshu's Topic");
			javax.jms.TopicPublisher pub =session.createPublisher(topic);
			pub.publish(message);
			response.getWriter().print("Initializing Deevanshu's Topic.....");
			response.getWriter().print("This message is successfully send to"+topic.getTopicName());
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
