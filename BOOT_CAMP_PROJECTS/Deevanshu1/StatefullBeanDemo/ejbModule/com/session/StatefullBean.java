package com.session;

import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class StatefullBean
 */
@Stateful
public class StatefullBean implements StatefullBeanRemote, StatefullBeanLocal {

    
    public StatefullBean() {
        
    }

    int counter = 0; 
    public String getName(){
        counter++;
        return "The bean number = "+ new Integer(counter).toString();	
    }
    
    @PrePassivate
	private void prePassivate(){
	    // Free resources 
	    // ...

	    System.out.println("Pre Passivative Bean");
	}

	@PostActivate
	private void postActivate()
	{
	    // Reactivate resources
	    // ...

	    System.out.println("Post Activate Bean");
	}

}
