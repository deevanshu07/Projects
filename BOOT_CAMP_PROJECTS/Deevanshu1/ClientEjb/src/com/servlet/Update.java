package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.ejb.Item;
import com.soft.ejb.FindItemSessionBeanRemote;
import com.soft.ejb.UpdateItemSessionBeanRemote;

public class Update extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
    public Update() 
    {
        super();
       
    }

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw= response.getWriter();
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		String itemName=request.getParameter("itemName");
		int itemPrepTime=Integer.parseInt(request.getParameter("itemPerpTime"));
		
		pw.println(itemId);
		pw.println(itemName);
		pw.println(itemPrepTime);
		
			
			InitialContext ic;
			
			
			try {
				ic= new InitialContext();
				UpdateItemSessionBeanRemote remote=(UpdateItemSessionBeanRemote)
						ic.lookup("UpdateItemSessionBean/remote");
				
				int update=remote.updateItem(itemId, itemName, itemPrepTime);
				if(update==6)
				{
					pw.print("Not Updated");
				}
				pw.println(update+"Items Updated Successfully");
			} 
			
			
			catch (NamingException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
