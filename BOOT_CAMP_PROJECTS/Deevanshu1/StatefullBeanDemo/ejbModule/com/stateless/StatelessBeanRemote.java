package com.stateless;

import javax.ejb.Remote;

@Remote
public interface StatelessBeanRemote 
{
	public String getname();

}
