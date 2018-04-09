package com.soft.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface FindItemSessionBeanRemote
{
	 public List findItem(int itemId);

}
