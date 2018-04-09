package com.soft.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ShowAllItemsSessionBeanLocal 
{
	public List showitems();

}
