package com.soft.ejb;

import javax.ejb.Local;

@Local
public interface UpdateItemSessionBeanLocal 
{
	public int updateItem(int itemId,String itemName,int itemPrepTime);
}
