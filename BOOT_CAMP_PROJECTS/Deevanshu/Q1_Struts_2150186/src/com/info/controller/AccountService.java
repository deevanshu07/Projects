package com.info.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// Class to check whether Account is Present or not
public class AccountService {

	public ArrayList<Account> getAccount()
	{
		ArrayList<Account> accountList= new ArrayList<Account>();
		Context ctx;
		try {
			ctx = new  InitialContext();
		
		 DataSource ds=(DataSource)ctx.lookup("java:OracleDS");
			Connection con=ds.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from Account");
			while(rs.next())
			{
				accountList.add(new Account(rs.getString(1),rs.getString(2)));
			}
			
			con.close();
			
		 } catch (Exception e) {
			System.out.println("Error in connection with Database  :"+e.getMessage());
			
		}
		return accountList;
	}
}
