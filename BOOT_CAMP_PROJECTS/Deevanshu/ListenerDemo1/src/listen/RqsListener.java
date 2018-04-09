package listen;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;


public class RqsListener implements ServletRequestAttributeListener
{

   
    public RqsListener() 
    {
       
    }

	
    public void attributeRemoved(ServletRequestAttributeEvent arg0) 
    {
       
    }

    public void attributeAdded(ServletRequestAttributeEvent arg0)
    {
        System.out.println("Object added in request");
    }

	
    public void attributeReplaced(ServletRequestAttributeEvent arg0)
    {
       
    }
	
}
