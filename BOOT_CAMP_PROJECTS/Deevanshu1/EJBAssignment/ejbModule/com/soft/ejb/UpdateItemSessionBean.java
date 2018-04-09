package com.soft.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Session Bean implementation class UpdateItemSessionBean
 */
@Stateless
public class UpdateItemSessionBean implements UpdateItemSessionBeanRemote, UpdateItemSessionBeanLocal {

 
    public UpdateItemSessionBean() 
    {
        
    }

	@Override
	public int updateItem(int itemId, String itemName, int itemPrepTime) 
	{
		Context ic;
		try 
		{
			ic = new InitialContext();
			DataSource ds= (DataSource) ic.lookup("java:OracleDS");
			String query="update item_ejb set itemName=?,itemPrepTime=? where itemId=?";
			Connection conn= ds.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(query);
			
			pstmt.setString(1,itemName);
			pstmt.setInt(2,itemPrepTime);
			pstmt.setInt(3,itemId);
			int row = pstmt.executeUpdate();
			System.out.println(row +" updated Successfully");
			
			if(row>0)
			return row;
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
