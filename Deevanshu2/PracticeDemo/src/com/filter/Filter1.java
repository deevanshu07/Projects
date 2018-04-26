package com.filter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class Filter1
 */
public class Filter1 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		List errorMsg= new LinkedList();
		String pId=request.getParameter("pId");
		String pName=request.getParameter("pName");
		
		
		
		if(pId.matches("[0-9]+"))
		{
			errorMsg.add("Name cannot contain digits");
			
		}
		
		if(pName.matches("[0-9]+"))
		{
			errorMsg.add("Name cannot contain digits");
			
		}
		
		System.out.println(pId.intern());
		
		
		
		if(!errorMsg.isEmpty())
		{
			request.setAttribute("errorMsg",errorMsg);
			RequestDispatcher disp= request.getRequestDispatcher("index.jsp");
			disp.forward(request,response);
			return;
			
		}
		
		
		
		chain.doFilter(request, response);
		
		System.out.println("Servlet Exit");
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException 
	{
		
		
	}

}
