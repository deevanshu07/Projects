package listen;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;


public class CtxAttribute implements ServletContextAttributeListener {

   
    public CtxAttribute() {
        
    }

	
    public void attributeAdded(ServletContextAttributeEvent arg0) 
    {
        System.out.println("Attribute Added in context");
        System.out.println(arg0.getName());
    }

	
    public void attributeRemoved(ServletContextAttributeEvent arg0)
    {
       
    }

	
    public void attributeReplaced(ServletContextAttributeEvent arg0) 
    {
        
    }
	
}
