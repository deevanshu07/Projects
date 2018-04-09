package com.info.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.*;
import javax.sql.*;

public class AddItems
{

	public int additem(Item item)
	{
		try
		{
			Context itx=new InitialContext();
			DataSource ds= (DataSource)itx.lookup("java:OracleDS");
			Connection conn=ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into items_selection values(?,?,?,?)");
			stmt.setInt(1, item.getItemId());
			stmt.setString(2, item.getItemName());
			stmt.setString(3, item.getItemPrepTime());
			stmt.setInt(4, item.getItemPrice());
			return stmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error" + e.getMessage());
			return 0;
		}
		
	}

}
