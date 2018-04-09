package com.infy.model;
import javax.naming.*;
import javax.sql.*;
import com.info.model1.*;


import java.sql.*;
public class MenuService
{
	public int addItem(Item item){
		try
		{
		Context itx=new InitialContext();
		DataSource ds=(DataSource)itx.lookup("java:OracleDS");
		Connection con=ds.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into item11 values(?,?,?)");
		stmt.setInt(1, item.getItemId());
		stmt.setString(2, item.getItemName());
		stmt.setString(3, item.getItemDesc());
		return stmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in connection"+e.getMessage());
			return 0;
		}
		
	}
}
