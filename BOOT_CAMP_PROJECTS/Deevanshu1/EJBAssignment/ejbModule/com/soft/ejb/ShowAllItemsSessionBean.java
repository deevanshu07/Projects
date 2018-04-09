package com.soft.ejb;

import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.info.ejb.Item;

@Stateless
public class ShowAllItemsSessionBean implements ShowAllItemsSessionBeanRemote, ShowAllItemsSessionBeanLocal {

    public ShowAllItemsSessionBean() 
    {
       
    }
    List<Item> itemList;
    public List showitems() 
    {
    	
    	Context ic;
		try {
			itemList= new ArrayList<Item>();
			ic = new InitialContext();
			DataSource ds= (DataSource) ic.lookup("java:OracleDS");
			String query="select * from item_ejb";
			Connection con=ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet result= stmt.executeQuery(query);
			
			while(result.next())
			{
				System.out.println("Getting Item");
				itemList.add(new Item(result.getInt(1),result.getString(2),result.getInt(3)));
			}
			return itemList;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return itemList;
		
    	
    }

}
