package com.soft.ejb;

import java.io.Serializable;
import javax.interceptor.*;

@SuppressWarnings("serial")
public class BussinessInterceptor implements Serializable
{

	@AroundInvoke
    public Object log1(InvocationContext ioc) throws Exception
    {
    	System.out.println("Intercepting call to my Bean"+ioc.getMethod().getName());
    	System.out.println("Log2");
		return ioc.proceed();
    	
    }
}
