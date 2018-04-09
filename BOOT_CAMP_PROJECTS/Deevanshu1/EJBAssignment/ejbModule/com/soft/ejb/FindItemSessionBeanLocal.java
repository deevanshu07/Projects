package com.soft.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface FindItemSessionBeanLocal 
{

	 public List findItem(int itemId);
}
