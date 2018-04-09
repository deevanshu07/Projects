package com.pack.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import service.MenuService;

/**
 * Application Lifecycle Listener implementation class Listener1
 *
 */
public class Listener1 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener1() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) 
    {
    	System.out.println("Listener Initialized");
    	ServletContext ctx =arg0.getServletContext();
    	String deevanshu=ctx.getInitParameter("deevanshu");
    	ctx.setAttribute("deevanshu",deevanshu);
    	MenuService menu= new MenuService();
    	
    	ArrayList itemList=menu.menuService(deevanshu);
    	
    	System.out.println(itemList);
    	
    	
    	
    	
        
    }

	
    public void contextDestroyed(ServletContextEvent arg0) 
    {
        
    }
	
}
