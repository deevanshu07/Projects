package com.soft.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.ejb.session.OrderProcessingBean;
import com.soft.ejb.session.OrderProcessingBeanRemote;
import com.soft.order.Order;

public class OrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	
  
    public OrderServlet()
    {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String orderType=request.getParameter("orderType");
		String orderDate=request.getParameter("orderDate");
		String orderAmount=request.getParameter("orderAmount");
		
		Order order= new Order();
		order.setOrderType(orderType);
		order.setOrderDate(orderDate);
		order.setOrderAmount(orderAmount);
		
		InitialContext ic;
		
		try 
		{
			ic= new InitialContext();
			OrderProcessingBeanRemote remote=(OrderProcessingBeanRemote)ic.lookup("OrderProcessingBean/remote");
			String str=remote.placeOrder(order);
			response.getWriter().print(str);
		} 
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
