package com.soft.ejb;

import javax.ejb.Remote;

@Remote
public interface AddItemSessionBeanRemote 
{
	 public int additem(int itemId,String itemName,int itemPrepTime);

}
