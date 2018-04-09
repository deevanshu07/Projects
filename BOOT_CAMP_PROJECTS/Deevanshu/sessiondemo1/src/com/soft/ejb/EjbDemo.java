package com.soft.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InitialContext ic;
		try {
			ic = new InitialContext();
			LoginBeanRemote remote=(LoginBeanRemote)ic.lookup("LoginBean/remote");
			
			boolean value= remote.validate("admin","admin");
			if(value)
				System.out.println("valid user");
			else
				System.out.println("Invalid User");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
				

	}

}
