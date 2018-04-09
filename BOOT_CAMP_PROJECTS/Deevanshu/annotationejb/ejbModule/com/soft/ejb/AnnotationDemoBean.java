package com.soft.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AnnotationDemoBean
 */
@Stateless
public class AnnotationDemoBean implements AnnotationDemoBeanRemote, AnnotationDemoBeanLocal {

    /**
     * Default constructor. 
     */
    public AnnotationDemoBean() {
        // TODO Auto-generated constructor stub
    }

  
    public String show()
    {
		return "Welcome message from bean";
    	
    }
    @PostConstruct
    public void init()
    {
    	System.out.println("Bean Instance is Created");
    }
    
    @PreDestroy
    public void destro()
    {
    	System.out.println("Bean Instance is Deleted");
    }
}
