package com.ejb.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.ejb.LoginBeanRemote;
import com.soft.login.Product;
import com.soft.product.ProductSessionBeanRemote;


public class Addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Addproduct() 
    {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List errorMsgs = new LinkedList();
		InitialContext ic;
		PrintWriter pw= response.getWriter();
		String productDesc=request.getParameter("productDesc");
		System.out.println(productDesc+"+");
		if(productDesc.length()==0||productDesc.equals(""))
		{
			
			errorMsgs.add("Item Desc Cannot be null");
			
		}
		int qty_on_hand=Integer.parseInt(request.getParameter("qty_on_hand"));
		if(qty_on_hand==0)
		{
			errorMsgs.add("This Field Cannot be zero");
		}
		int unit_price=Integer.parseInt(request.getParameter("unit_price"));
		if(unit_price==0)
		{
			errorMsgs.add("This Field Cannot be zero");
		}
		 if ( !errorMsgs.isEmpty() ) 
	        {
			 request.setAttribute("errorMsgs", errorMsgs);
	            RequestDispatcher view = request.getRequestDispatcher("Addproduct.jsp");
	            view.forward(request, response);
	       
	            return;
	        }
		try 
		{
			
			
			ic= new InitialContext();
			
			ProductSessionBeanRemote remote=(ProductSessionBeanRemote)ic.lookup("ProductSessionBean/remote");
			Product product= new Product();
			product.setProductDesc(productDesc);
			product.setQty_on_hand(qty_on_hand);
			product.setUnit_price(unit_price);
			String s= remote.addItem(product);
			if(s.equals("success"))
			{
				pw.println("Product Added Successfully");
			}
			else
			{
				pw.println("Error in submission");
				
			}
			
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		

	}

	/*String errorMsg="Product Description cannot be null";
	System.out.println("Item null");
	errorMsgs.add(errorMsg);
	request.setAttribute("errorMsgs",errorMsg);
	RequestDispatcher view = request.getRequestDispatcher("Addproduct.jsp");
	view.forward(request, response);
	response.sendRedirect("Addproduct.jsp");
	return;*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
