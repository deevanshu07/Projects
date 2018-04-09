package com.vodacom.controller;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vodacom.model.Plan;
import com.vodacom.service.GetData;

public class GetRechargeController extends ActionSupport implements SessionAware {
	
	String mobileNo;
	String plan;
	int rechargeId;
	Map session;
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public String execute()
	{
		GetData obj= new GetData();
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=obj.getPlan();
		
		session.put("planList",list);
		return SUCCESS;
				
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
		
	}
	public int getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(int rechargeId) {
		this.rechargeId = rechargeId;
	}
	
	

}
