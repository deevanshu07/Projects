package com.soft.classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TestServer implements Test
{

	public String show()
	{
		
		return "This is Remote Server";
	}

	public TestServer() 
	{
		super();
		
	}
	
	public static void main(String[] args) 
	{
		if(System.getSecurityManager()==null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		
		String name="Test Server";
		TestServer server= new TestServer();
		
		try 
		{
			Remote stub=(Remote)UnicastRemoteObject.exportObject(server,0);
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("Server Bind");
		} 
		catch (Exception e) 
		{
		
			System.out.println("System Bind Exception");
			e.printStackTrace();
		}
		
	}

	
	

}
