package com.soft.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass {

	
	public static void main(String[] args) 
	{
		 try   
		 {
			 String str="Rahul";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:Xe","hr","hr");
			/*String query="insert into person values('"+name+"','"+age+"','"+location+"')";*/
			
			String query="select age from person where name='"+str+"'";
			java.sql.Statement stmt=con.createStatement();
			
			ResultSet result= stmt.executeQuery(query);
			result.next();
			System.out.println(result.getString(1));


			
					
				} catch (Exception  e) 
				{
					
					e.printStackTrace();
				}

	}

}
