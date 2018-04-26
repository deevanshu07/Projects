package com.soft.model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class Server implements Airtel{
	
	static 
	{
		try 
	
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:Xe","hr","hr");
	} 
		
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	}
	
	public static void main(String[] args) 
	{
	

	
	

	}

	@Override
	public String getBalance(Customer customer) throws RemoteException
	{
		return null;
		
	}

}
