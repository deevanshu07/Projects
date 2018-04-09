package com.soft.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.info.ejb.Item;

/**
 * Session Bean implementation class FindItemSessionBean
 */
@Stateless
public class FindItemSessionBean implements FindItemSessionBeanRemote, FindItemSessionBeanLocal {

   
    public FindItemSessionBean() 
    {
       
    }
    List <Item>SearchList;

    public List findItem(int itemId)
    {
    	SearchList= new ArrayList<>();
    	
    	Context ic;
    	Item item;
		try {
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:OracleDS");
			Connection conn= ds.getConnection();
			String query="select * from item_ejb where itemId="+itemId;
			Statement stmt= conn.createStatement();
			ResultSet result= stmt.executeQuery(query);
			while(result.next())
			{
				SearchList.add(new Item(result.getInt(1),result.getString(2),result.getInt(3)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SearchList;
    	
    	
    }
}
