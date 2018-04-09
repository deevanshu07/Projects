package com.ejb.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soft.ejb.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() 
    {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session=request.getSession();
		InitialContext ic;
		PrintWriter pw= response.getWriter();

		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String seletedItem=request.getParameter("selectedItem");
		session.setAttribute("userId", userId);

		pw.println(userId+"\t"+password+"\t"+seletedItem);
		
		try 
		{
			ic= new InitialContext();
			LoginBeanRemote remote=(LoginBeanRemote)ic.lookup("LoginBean/remote");
			String l=remote.loginValidate(userId, password);
			if(l.equals("Admin"))
			{
				response.sendRedirect("Adminservices.jsp");
			}
			else if(l.equals("Client"))
			{
				response.sendRedirect("ClientServices.jsp");
			}
			else if(l.equals("Unsuccessful"))
			{
			response.sendRedirect("Login.jsp");
			}
		} 
		
		catch (NamingException e) 
		{
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);

	}

}
