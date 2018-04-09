package com.ejb.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soft.login.Product;
import com.soft.product.ProductSessionBeanRemote;

public class Purchaseproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Purchaseproduct() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		HttpSession session=request.getSession();
		
		PrintWriter pw=response.getWriter();
		List <Integer>l=new ArrayList<Integer>();
		String selectedItem=request.getParameter("selectedProduct");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
	pw.println("Products are"+selectedItem+quantity);
		int bill=0;
		InitialContext ic;
		List <Product> productList;
		try 
		{
		ic=new InitialContext();
		ProductSessionBeanRemote remote=(ProductSessionBeanRemote)ic.lookup("ProductSessionBean/remote");
		productList=remote.allProducts();
			
		for (Product ite : productList) 
			{
				
				String productDesc=ite.getProductId()+"-"+ite.getProductDesc();
				if(productDesc.equals(selectedItem))
				{
					bill=bill+(quantity*ite.getUnit_price());
					System.out.println("Bill Generated="+bill);
					l.add(bill);
				}
				
			}
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}