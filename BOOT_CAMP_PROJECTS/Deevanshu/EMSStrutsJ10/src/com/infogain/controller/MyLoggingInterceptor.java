package com.infogain.controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyLoggingInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {

		String className = invocation.getAction().getClass().getName();
		long startTime = System.currentTimeMillis();
		System.err.println("Before calling action: " + className);
		System.out.print("Before Returning result");
		String result = invocation.invoke();
		System.out.print("After Returning result");
		long endTime = System.currentTimeMillis();
		System.out.println("After calling action: " + className
				+ " Time taken: " + (endTime - startTime) + " ms");

		return result;
	}

	public void destroy() {
		System.out.println("Destroying MyLoggingInterceptor...");
	}
	public void init() {
		System.out.println("Initializing MyLoggingInterceptor...");
	}
}
