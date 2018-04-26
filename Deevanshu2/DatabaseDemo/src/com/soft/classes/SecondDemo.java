package com.soft.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SecondDemo 
{

	
	public static void main(String[] args) 
	{
		try
	      {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","hr","hr");
	        
	        
	        Statement stmt = con.createStatement();
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Jobs");
	        
				ResultSetMetaData md = rs.getMetaData();
				int col = md.getColumnCount();
				System.out.println("Number of Column : "+ col);
				System.out.println("Columns Name: ");
				for (int i = 1; i <= col; i++)
				{
					String col_name = md.getColumnName(i);
					System.out.print(col_name);
					System.out.println();
				}
	      }
	      
		catch(Exception e) 
		{
	         e.printStackTrace();
	     
		}

	}

}
