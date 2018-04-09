package com.infogain.controller;

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
		/*ActionContext ac=ActionContext.getContext();
		//HttpServletRequest request=(HttpServletRequest)ac.get(ServletActionContext.HTTP_REQUEST);
		//HttpServletResponse response=(HttpServletResponse)ac.get(ServletActionContext.HTTP_REQUEST);
		//HttpSession session1=(HttpSession)ac.get(ServletActionContext.SESSION);
		//HttpSession session11=ServletActionContext.
		Map session1=(Map)ac.get(ServletActionContext.SESSION);
		
		//ServletContext ctx=(ServletContext)ac.get(ServletActionContext.APPLICATION);
		
		HttpSession hs=ServletActionContext.getRequest().getSession();
		HttpSession hs2=(HttpSession) ActionContext.getContext().getSession();
		
		
		
		
		
		<%=session%><br>
	    <b>Session Context: </b><%=session.getSessionContext() %><br>
	    <b>Session Time: </b><%=new Date(session.getLastAccessedTime())%>
	    

		session1.remove("currentuser");
		  System.out.println(session1.get("currentuser"));
		//session.removeAttribute("currentuser");  or
//		session.invalidate();
*/		return "success";
		
	}

	
	
	

}
