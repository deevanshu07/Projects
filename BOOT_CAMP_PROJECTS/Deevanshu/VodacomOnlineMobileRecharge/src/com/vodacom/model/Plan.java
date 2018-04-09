package com.vodacom.model;

import java.io.Serializable;

public class Plan implements Serializable
{
	int planId;
	String planName;
	int recharge;
	int offer;
	
	public Plan(int planId, String planName, int recharge, int offer) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.recharge = recharge;
		this.offer = offer;
	}
	
	
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getRecharge() {
		return recharge;
	}
	public void setRecharge(int recharge) {
		this.recharge = recharge;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}

}
