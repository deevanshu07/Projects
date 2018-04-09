package com.session;

import javax.ejb.Remote;

@Remote
public interface StatefullBeanRemote 
{
	public String getName();

}
