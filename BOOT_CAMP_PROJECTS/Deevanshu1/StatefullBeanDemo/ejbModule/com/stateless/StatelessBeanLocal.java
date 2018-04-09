package com.stateless;

import javax.ejb.Local;

@Local
public interface StatelessBeanLocal 
{
	public String getname();

}
