package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.ejb.AddItemSessionBeanRemote;

public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		String itemName=request.getParameter("itemName");
		int itemPrepTime=Integer.parseInt(request.getParameter("itemPrepTime"));
		pw.println(itemId);
		pw.println(itemName);
		pw.println(itemPrepTime);
		
		InitialContext ic;
		
		try 
		{
			ic= new InitialContext();
			
	AddItemSessionBeanRemote remote=(AddItemSessionBeanRemote)ic.lookup("AddItemSessionBean/remote");
		int result=remote.additem(itemId, itemName, itemPrepTime);
		/*if(result>0)
		{
			pw.println("Items Added");
		}
		else
			pw.println("Items Not Entered");
	
		} 
		*/
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
