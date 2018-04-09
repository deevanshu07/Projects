package com.soft.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			
			InitialContext ic = new InitialContext();
			AnnotationDemoBeanRemote remote=(AnnotationDemoBeanRemote)
					ic.lookup("AnnotationDemoBean/remote");
			System.out.println(remote.show());
			//System.out.println("Bean Intialized");
			
			
			/*InitialContext ic = new InitialContext();
			LoginBeanRemote remote=(LoginBeanRemote)ic.lookup("LoginBean/remote");
			
			boolean value= remote.validate("admin","admin");
			if(value)
				System.out.println("valid user");
			else
				System.out.println("Invalid User");*/
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
				

	}

}
