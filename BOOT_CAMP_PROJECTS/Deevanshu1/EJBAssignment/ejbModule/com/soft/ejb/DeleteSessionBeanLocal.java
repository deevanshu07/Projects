package com.soft.ejb;

import javax.ejb.Local;

@Local
public interface DeleteSessionBeanLocal 
{
	public int deleteitem(int itemId);
	public int deleteall();

}
