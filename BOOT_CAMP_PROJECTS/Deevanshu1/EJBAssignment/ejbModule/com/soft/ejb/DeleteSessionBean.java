package com.soft.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@Interceptors(BussinessInterceptor.class)
@Stateless
public class DeleteSessionBean implements DeleteSessionBeanRemote, DeleteSessionBeanLocal {

    
    public DeleteSessionBean() 
    {
      
    }

	@Override
	public int deleteitem(int itemId) 
	{
		try
		{
		Context ic= new InitialContext();
		DataSource ds= (DataSource) ic.lookup("java:OracleDS");
		String query="delete from item_ejb where itemId="+itemId;
		Connection con=ds.getConnection();
		PreparedStatement pstmt= con.prepareStatement(query);
		System.out.println("Item is Deleted");
		
		int result=pstmt.executeUpdate();
		if(result>0)
		{
			return 1;
		}
		else
		return 0;
	}
	catch (Exception e) 
	{
		
		e.printStackTrace();
	}
	return 6;
	}

	@Override
	public int deleteall() 
	{
		try
		{
		Context ic= new InitialContext();
		DataSource ds= (DataSource) ic.lookup("java:OracleDS");
		String query="delete item_ejb";
		Connection con=ds.getConnection();
		PreparedStatement pstmt= con.prepareStatement(query);
		System.out.println("Item is Deleted");
		
		int result=pstmt.executeUpdate();
		if(result>0)
		{
			return 1;
		}
		else
		return 0;
	}
	catch (Exception e) 
	{
		
		e.printStackTrace();
	}
	return 6;
	
	}
	
	
}


