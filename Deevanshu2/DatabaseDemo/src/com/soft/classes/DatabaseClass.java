package com.soft.classes;

import java.sql.*;

public class DatabaseClass {

	public static void main(String[] args) 
	{
		try
	      {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","hr","hr");
	        Statement stmt = con.createStatement();
	         stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	         String str="'AD_ASST'";
	         ResultSet rs = stmt.executeQuery("SELECT job_id, job_title FROM jobs WHERE job_id="+str);
	         rs.next();
	         System.out.println(rs.getString(1) + ", " + rs.getString(2));
	         rs.updateString("job_title","Administration Department Head");
	          rs.updateRow();
	          Statement stmt1 = con.createStatement();
	          ResultSet rs1 = stmt1.executeQuery("SELECT job_id, job_title FROM jobs WHERE job_id="+str);
	         while(rs1.next())
	         {
	          System.out.println(rs1.getString(1) + ", " + rs1.getString(2) );	
	         }
	          con.close();
	      }
	      
		catch(Exception e) 
		{
	         e.printStackTrace();
	     
		}

	}

}
