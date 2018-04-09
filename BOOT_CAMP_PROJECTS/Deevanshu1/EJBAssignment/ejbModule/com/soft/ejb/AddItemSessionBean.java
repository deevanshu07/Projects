package com.soft.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import com.info.ejb.Item;

import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Session Bean implementation class AddItemSessionBean
 */
@Interceptors(BussinessInterceptor.class)
@Stateless
public class AddItemSessionBean implements AddItemSessionBeanRemote, AddItemSessionBeanLocal 
{

    public AddItemSessionBean() 
    {
        
    }
 
    public int additem(int itemId,String itemName,int itemPrepTime)
    {
  
    	try 
    	{
			Context ic= new InitialContext();
			DataSource ds= (DataSource) ic.lookup("java:OracleDS");
			String query="insert into item_ejb values(?,?,?)";
			Connection con=ds.getConnection();
			PreparedStatement pstmt= con.prepareStatement(query);
			
			System.out.println("Items Are entered");
			pstmt.setInt(1, itemId);
			pstmt.setString(2,itemName);
			pstmt.setInt(3,itemPrepTime);
			int result=pstmt.executeUpdate();
			/*if(result>0)
			{
				return 1;
			}
			else
			return 0;*/
			con.close();
		} 
    	catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		return 1;
		
    	
    }
    @PostConstruct
    public void init()
    {
    	System.out.println("Added Item Bean is Created");
    }
    
    @PreDestroy
    public void destro()
    {
    	System.out.println("Added Item Bean is Deleted");
    }
    
    
   
}
