package com.ejb.Login;

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

import com.soft.login.Product;
import com.soft.product.ProductSessionBeanRemote;

public class Listproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Listproducts()
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		InitialContext ic;
		List<Product> productList;
		PrintWriter pw= response.getWriter();
		try 
		{
			productList=new ArrayList<>();
			ic= new InitialContext();
			ProductSessionBeanRemote remote=(ProductSessionBeanRemote)ic.lookup("ProductSessionBean/remote");
			productList=remote.allProducts();
			
			for (Product ite : productList) 
			{
				pw.print(ite.getProductId()+"\t"+ite.getProductDesc()+"\t"+ite.getQty_on_hand()+"\t"+
						ite.getUnit_price());
				pw.println();
				
			}
			
		} 
		catch (NamingException e) 
		{
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}