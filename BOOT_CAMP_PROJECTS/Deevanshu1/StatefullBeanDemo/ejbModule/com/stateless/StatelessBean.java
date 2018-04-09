package com.stateless;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class StatelessBean
 */
@Stateless
public class StatelessBean implements StatelessBeanRemote, StatelessBeanLocal {

    
    public StatelessBean() {
        // TODO Auto-generated constructor stub
    }

    int counter = 0; 
    public String getname(){
        counter++;
        return "The bean number = "+ new Integer(counter).toString();	
    }

}
