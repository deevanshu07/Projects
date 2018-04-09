package com.soft.ejb;

import javax.ejb.Remote;

@Remote
public interface DemoInterceptorBeanRemote 
{
	 public String display(String name);
	 public String show();

}
