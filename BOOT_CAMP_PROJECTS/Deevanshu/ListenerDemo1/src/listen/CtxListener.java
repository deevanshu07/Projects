package listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.*;
import java.util.*;
/**
 * Application Lifecycle Listener implementation class CtxListener
 *
 */
public class CtxListener implements ServletContextListener {

  
    public CtxListener() 
    {
        
    }

	
    public void contextDestroyed(ServletContextEvent arg0)
    {
        
    }

	
    public void contextInitialized(ServletContextEvent arg0) {
       List <Employee>emps=new ArrayList<Employee>();
       emps.add(new Employee(1,"Ankit",32));
       emps.add(new Employee(2,"Amit",35));
       arg0.getServletContext().setAttribute("emps", emps);
       System.out.println("Context Initialized");
    }
	
}
