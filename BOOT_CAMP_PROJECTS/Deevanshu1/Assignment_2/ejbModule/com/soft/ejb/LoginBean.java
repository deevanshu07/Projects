package com.soft.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.soft.login.LoginDetails;

@Stateless
public class LoginBean implements LoginBeanRemote, LoginBeanLocal {

   
	@PersistenceContext(unitName="TrainingUnit44")
	private EntityManager em;
    public LoginBean() 
    {
  
    }
    
	@Override
	public String loginValidate(String userId, String password) 
	{
		
		
		LoginDetails login=(LoginDetails)em.find(LoginDetails.class, userId);
		if(login.getUserType().equalsIgnoreCase("Admin"))
		{
			return "Admin";
		}
		else if(login.getUserType().equalsIgnoreCase("Client"))
			return "Client";
		
		else if(login.equals(null))
			return "Unsuccessful";
		else
			return "Unsuccessful";
		
	}

}