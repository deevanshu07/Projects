package com.info.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UpdateMobile 
{

	public String update(String accountnumber,String mobileNumber)
	{
		Context ctx;
		try {
			ctx = new  InitialContext();
		
			System.out.println(mobileNumber+accountnumber);
		
		 DataSource ds=(DataSource)ctx.lookup("java:OracleDS");
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement("update account set mobileno=? where accountno=?");
			ps.setString(1,mobileNumber);
			ps.setString(2,accountnumber);
			
			int result=ps.executeUpdate();
			
			if(result>0)
			{
				return "updated";
			}
			
			
			con.close();
		} catch (Exception e) {
			System.out.println("Error in connection with Database  :"+e.getMessage());
			
		}
		return "notupdated";
		
	}

}
