package com.info.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;

import com.opensymphony.xwork2.ActionContext;

public class LogOutAction  {
	

	public String execute()
	{
		HttpSession hs=ServletActionContext.getRequest().getSession();
		hs.invalidate();
		return "success";
		
	}

}
