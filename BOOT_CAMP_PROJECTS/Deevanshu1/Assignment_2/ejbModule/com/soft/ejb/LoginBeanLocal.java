package com.soft.ejb;

import javax.ejb.Local;

@Local
public interface LoginBeanLocal 
{
	public String loginValidate(String userId,String password);

}
