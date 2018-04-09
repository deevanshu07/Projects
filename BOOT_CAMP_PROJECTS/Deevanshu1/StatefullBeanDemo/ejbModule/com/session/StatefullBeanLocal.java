package com.session;

import javax.ejb.Local;

@Local
public interface StatefullBeanLocal 
{
	public String getName();
}
