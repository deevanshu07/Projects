package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.ejb.Item;
import com.soft.ejb.*;


/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

List <Item>searchList;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		pw.println("ID");
		pw.println(id);
		InitialContext ic;
		searchList= new ArrayList<Item>();
		
		
	try {
		ic= new InitialContext();
FindItemSessionBeanRemote remote= (FindItemSessionBeanRemote)ic.lookup("FindItemSessionBean/remote");
searchList=remote.findItem(id);

for (Item ite : searchList) 
{
	pw.print(ite.getItemId());
	pw.print(ite.getItemName());
	pw.print(ite.getPrepTime());
	
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
