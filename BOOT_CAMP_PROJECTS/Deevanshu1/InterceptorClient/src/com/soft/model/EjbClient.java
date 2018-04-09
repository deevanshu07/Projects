package com.soft.model;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.soft.ejb.DemoInterceptorBeanRemote;

@SuppressWarnings("unused")
public class EjbClient 
{
	public static void main(String[] args) 
	{
		InitialContext ic;
		try {
			ic= new InitialContext();
			DemoInterceptorBeanRemote remote=(DemoInterceptorBeanRemote )ic.lookup
					("DemoInterceptorBean/remote");
			String str=remote.display("amit");
			String str1=remote.show();
			System.out.println(str);
			System.out.println(str1);
			
			
		} catch (Exception e) 
		
		{
			
			e.printStackTrace();
		}
		
	}

}
