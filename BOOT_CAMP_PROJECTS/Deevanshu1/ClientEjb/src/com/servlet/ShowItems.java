package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.ejb.Item;
import com.soft.ejb.ShowAllItemsSessionBeanRemote;

public class ShowItems extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public ShowItems() 
    {
        super();
    }

    List<Item> itemList;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
		{
		itemList= new ArrayList<Item>();
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		String userName=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		InitialContext ic;
		try {
			ic = new InitialContext();
			ShowAllItemsSessionBeanRemote remote=
					(ShowAllItemsSessionBeanRemote)ic.lookup("ShowAllItemsSessionBean/remote");
			
			itemList=remote.showitems();
			pw.println("Item Name");
			for (Item ite : itemList) {
				pw.print(ite.getItemId());
				pw.print(ite.getItemName());
				pw.println();
			}
			
			
			
			
			
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
