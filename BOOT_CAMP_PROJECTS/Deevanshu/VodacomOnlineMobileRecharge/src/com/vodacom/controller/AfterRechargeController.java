package com.vodacom.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;

import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;
import com.vodacom.model.Plan;
import com.vodacom.service.SetRecharge;

public class AfterRechargeController extends ActionSupport {
	String mobileNo;
	String plan;
	int rechargeId;
	static int incrementor=0;
	int planselected;
	
	
	public String setRecharge()
	{
	/*	incrementor++;
		rechargeId=incrementor;
		SetRecharge obj= new SetRecharge();
		
		int balance=obj.getBalance(mobileNo);
		if(planselected==1)
		{
			balance=balance+110;
		}
		if(planselected==2)
		{
			balance=balance+220;
		}
		if(planselected==3)
		{
			balance=balance+330;
		}
		if(planselected==4)
		{
			balance=balance+440;
		}
		obj.updateBalance(mobileNo, balance);
		obj.enterRecharge(rechargeId, mobileNo, planselected);
		*/
		
	
		System.out.println("PLAN SELECTED ID IS "+planselected);
		
		
		
		
		
		return SUCCESS;
	}
	

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

	public int getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(int rechargeId) {
		this.rechargeId = rechargeId;
	}


	

	public int getPlanselected() {
		return planselected;
	}


	public void setPlanselected(int planselected) {
		this.planselected = planselected;
	}

}
