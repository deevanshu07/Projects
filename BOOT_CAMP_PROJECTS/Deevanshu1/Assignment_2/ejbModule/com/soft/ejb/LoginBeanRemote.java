package com.soft.ejb;

import javax.ejb.Remote;

@Remote
public interface LoginBeanRemote 
{
	public String loginValidate(String userId,String password);

}
