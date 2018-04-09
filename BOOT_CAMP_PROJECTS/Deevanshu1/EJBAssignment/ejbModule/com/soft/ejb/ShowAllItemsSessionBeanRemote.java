package com.soft.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ShowAllItemsSessionBeanRemote 
{
	public List showitems();

}
