package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.jboss.beans.metadata.api.annotations.Create;



@SuppressWarnings("unused")
public class MenuService
{
	public static ArrayList<Item> items= new ArrayList<>(); 

	public static ArrayList<Item> addItem(){
		try
		{
		Context itx=new InitialContext();
		String str="select * from items_selection";
		DataSource ds=(DataSource)itx.lookup("java:OracleDS");
		Connection con=ds.getConnection();
		Statement stmt= con.createStatement();
		
		ResultSet rs= stmt.executeQuery(str);
		
		while(rs.next())
		{
			items.add(new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
		
		
		}
		catch(Exception e)
		{
			System.out.println("Error in connection"+e.getMessage());
			return null;
		}
		return items;
	}
	

}
