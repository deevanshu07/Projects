package com.soft.ejb;

import javax.ejb.Local;

@Local
public interface AddItemSessionBeanLocal 
{
	 public int additem(int itemId,String itemName,int itemPrepTime);

}
