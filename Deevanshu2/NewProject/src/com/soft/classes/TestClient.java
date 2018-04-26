package com.soft.classes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.imageio.spi.RegisterableService;

public class TestClient 
{

	
	public static void main(String[] args) 
	{
		if(System.getSecurityManager()==null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		
	
		try 
		{
			String name="TestServer";
			Registry registry=LocateRegistry.getRegistry(args[0]);
			Test comp=(Test)registry.lookup(name);
			String s1=comp.show();
			System.out.println("Server"+s1);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		

	}

}
