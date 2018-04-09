package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class Update 
{

	public int updateItem(Item item)
	{
		try
		{
			Context itx=new InitialContext();
			DataSource ds= (DataSource)itx.lookup("java:OracleDS");
			Connection conn=ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("update items_selection set " +
					"ITEMPRICE=ITEMPRICE+? where ITEMNAME=?" 
		);
			
			stmt.setInt(1, item.getItemPrice());
			stmt.setString(2, item.getItemName());
			
			return stmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error" + e.getMessage());
			return 0;
		}
		
	}

}
