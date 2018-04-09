package com.session;

import javax.ejb.Remote;

import com.items.Items;

@Remote
public interface AddItemsRemote 
{
	public int addItem(Items item);

}
