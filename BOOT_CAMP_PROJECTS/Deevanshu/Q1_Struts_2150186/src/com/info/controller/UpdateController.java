package com.info.controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateController extends ActionSupport implements SessionAware 
{
	
	private Map session;
	String notavailable="Na";
	String accountNumber;
	String mobileNumber;
	AccountService account= new AccountService();
	
	List<Account> accountList=account.getAccount();
	
	UpdateMobile up= new UpdateMobile();
	

// Function to update the Mobile Number
	public String updateMobile()
	{
		for(Account ite:accountList)
		{
			if(accountNumber.equals(ite.getAccountNumber()))	
			{
				
			String str=	up.update(accountNumber, mobileNumber);
			if(str.equals("updated"))
			{
				session.put("accountNumber",accountNumber);
				session.put("mobileNumber", mobileNumber);
				return SUCCESS;

			}
			else break;
			
		}
			
			else
			{
				session.put("notavailable",notavailable);
				return "mismatch";
			}
			
			}
			
		return "mismatch";
		
		
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
		
	}

	public Map getSession() {
		return session;
	}


}
