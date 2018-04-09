package com.soft.ejb;

import javax.ejb.Remote;

@Remote
public interface LoginBeanRemote 
{
	public boolean validate(String username,String password);

}
