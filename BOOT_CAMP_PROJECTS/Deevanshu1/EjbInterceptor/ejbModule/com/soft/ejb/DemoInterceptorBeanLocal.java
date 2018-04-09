package com.soft.ejb;

import javax.ejb.Local;

@Local
public interface DemoInterceptorBeanLocal 
{
	 public String display(String name);
	 public String show();

}
