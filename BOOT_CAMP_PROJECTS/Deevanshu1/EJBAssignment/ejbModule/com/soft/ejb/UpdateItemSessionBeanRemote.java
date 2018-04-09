package com.soft.ejb;

import javax.ejb.Remote;

@Remote
public interface UpdateItemSessionBeanRemote 
{
	public int updateItem(int itemId,String itemName,int itemPrepTime);

}
