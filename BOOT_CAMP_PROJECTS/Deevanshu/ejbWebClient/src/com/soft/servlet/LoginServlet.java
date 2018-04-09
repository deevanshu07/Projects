package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;


import com.soft.ejb.LoginBeanRemote;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() 
    {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		String userName=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		InitialContext ic;
		try {
			ic = new InitialContext();
			LoginBeanRemote remote=(LoginBeanRemote)ic.lookup("LoginBean/remote");
			
			boolean value= remote.validate(userName,password);
			if(value)
				pw.print("valid user");
			else
				pw.print("Invalid User");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
