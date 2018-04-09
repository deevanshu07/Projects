package com.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.soft.FindEmployeeRemote;

public class JpaDemoClient {



	public static void main(String[] args) 
	{
		InitialContext ic;
		System.out.println("Finding Client");
		
		try
		{
			ic= new InitialContext();
			FindEmployeeRemote remote=(FindEmployeeRemote) ic.lookup("FindEmployee/remote");
			String name=remote.findEmployeee(2);
			System.out.println(name);
		} 
		
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

}
