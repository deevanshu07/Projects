package com.session;

import javax.ejb.Local;

import com.items.Items;

@Local
public interface AddItemsLocal 
{
	public int addItem(Items item);
	

}
