package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.ejb.DeleteSessionBeanRemote;


public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Delete() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();
		InitialContext ic;
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		
		try {
			ic = new InitialContext();
			DeleteSessionBeanRemote remote=(DeleteSessionBeanRemote)ic.lookup("DeleteSessionBean/remote");
			int delete=remote.deleteitem(itemId);
			if(delete==1)
			{
				pw.print("Item Deleted");
			}
			else if(delete==6) pw.print("Not Deleted");
			
		} 
		
		catch (NamingException e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
