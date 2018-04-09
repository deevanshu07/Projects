package com.soft.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.*;

import com.soft.bi.BussinessInterceptor;

@Interceptors(BussinessInterceptor.class)
@Stateless
public class DemoInterceptorBean implements DemoInterceptorBeanRemote, DemoInterceptorBeanLocal {

   
    public DemoInterceptorBean() 
    {
       
    }
    
    @Override
    public String display(String name)
    {
    	
    	return "This is Ejb using Interceptor";
    }
    
    @Override
    public String show()
    {
    	return "This is Show Method";
    }
    
    @AroundInvoke
    public Object log(InvocationContext ioc) throws Exception
    {
    	System.out.println("Intercepting call to my Bean1"+ioc.getMethod().getName());
    	System.out.println("Log");
		return ioc.proceed();
    	
    }
    @PostConstruct
    public void preMethod()
    {
    	System.out.println("INVOKE BEFORE Delete Item");
    }
    

}
