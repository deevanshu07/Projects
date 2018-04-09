package com.infogain.controller;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;


public class ParamIntercept implements Interceptor {

	
	public String intercept(ActionInvocation ai) throws Exception {
		
		System.out.println("enetred in param....");		
		 ServletRequest request=ServletActionContext.getRequest();		 
		
		 ValueStack stack=ai.getStack();
		 /*Object ob=stack.pop();
			now dynmically load ob into jvm,and use reflection to get method name and call 
			the setter methods of action object to set data and now fetch data from action object on to jsp*/
		 	 
		 Enumeration enm=request.getParameterNames();
		 while(enm.hasMoreElements())
		 {
			 String pName=(String) enm.nextElement();
			 String pValue=request.getParameter(pName);
			 
			 stack.set(pName,pValue);
			 System.out.println(pName);
			 System.out.println(pValue);
		 }
		 
		 String nextResource=ai.invoke();
		
		 return nextResource;
		 
		 
		 
		/* 
		 
		 String password=stack.findString("password");
		 if(password.length()>6)
		 {
			 System.out.println("enter in if");
			 String nextResource=ai.invoke();
			 System.out.println("nextresource is "+nextResource);
			 System.out.println("code to make any change in response is executed");
			 System.out.println("end of param");
		 		return "arbitratry";
		 }
			 		 
		 else
		 {
			 return "invalid";

		 }	 */
		 
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	

}
