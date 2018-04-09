package com.soft.ejb;

import javax.ejb.Remote;

@Remote
public interface DeleteSessionBeanRemote 
{
	public int deleteitem(int itemId);
	public int deleteall();

}
