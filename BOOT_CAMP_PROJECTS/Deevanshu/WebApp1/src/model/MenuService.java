
package model;
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
import Deevanhu.*;

public class MenuService  {

	ArrayList<itemClass> itemList=new ArrayList<itemClass>();
	
	public ArrayList<itemClass> menuService(String url){
		try
		{
		Context ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup(url);
		Connection con=ds.getConnection();
		Statement stmt=con.createStatement();

		String query="select * from item";
		ResultSet result=stmt.executeQuery(query)	;
		while(result.next())
		{
	
	itemList.add(new itemClass(result.getString(1),result.getString(2),result.getInt(3),result.getString(4)));
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return itemList;
	}
	
	
	
	
}
