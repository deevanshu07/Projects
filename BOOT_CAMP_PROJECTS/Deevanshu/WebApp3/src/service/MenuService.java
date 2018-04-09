package service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;
import javax.sql.*;
import javax.naming.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MenuService  {

	ArrayList<ItemClass> itemList=new ArrayList<ItemClass>();
	
	public ArrayList<ItemClass> menuService(String url){
		try
		{
		Context ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup(url);
		Connection con=ds.getConnection();
		Statement stmt=con.createStatement();

		String query="select * from item1";
		ResultSet result=stmt.executeQuery(query)	;
		while(result.next())
		{
	
			itemList.add(new ItemClass(result.getString(1),result.getInt(2),
			result.getString(3),result.getString(4)));
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return itemList;
	}
	
	
	
	
}
