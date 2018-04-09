package listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class CtxListen implements 
ServletContextListener, ServletContextAttributeListener, HttpSessionListener, 
HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, ServletRequestListener, ServletRequestAttributeListener 
{
	

   

    public CtxListen() 
    {
       
    }

	
    public void sessionCreated(HttpSessionEvent arg0) {
       System.out.println("Session Created");
    }

    public void attributeRemoved(ServletContextAttributeEvent arg0) {
       
    }


    public void attributeAdded(ServletRequestAttributeEvent arg0) {
        System.out.println("Request Attribute Added");
        System.out.println(arg0.getName());
    }

	
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
       
    }

    public void sessionWillPassivate(HttpSessionEvent arg0) {
        
    }


    public void contextInitialized(ServletContextEvent arg0) {
       
    	ServletContext ctx=arg0.getServletContext();
    	System.out.println(ctx.getInitParameter("Global"));
        System.out.println("Context Initialized");
        ctx.setAttribute("name1", "Ankit Arora");
    }

	
    public void attributeAdded(ServletContextAttributeEvent arg0) {
    	System.out.println("Context Attribute Added");
    	System.out.println(arg0.getName());
    }


    public void requestDestroyed(ServletRequestEvent arg0) {
      
    }

	
    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent arg0) {
        System.out.println("Object bound to session");
    }


    public void requestInitialized(ServletRequestEvent arg0) {
       
    }


    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }


    public void sessionDidActivate(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
        // TODO Auto-generated method stub
    }

	
    public void attributeAdded(HttpSessionBindingEvent arg0) 
    
    {
        System.out.println("Attribute Added in Session");
        System.out.println(arg0.getName());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
