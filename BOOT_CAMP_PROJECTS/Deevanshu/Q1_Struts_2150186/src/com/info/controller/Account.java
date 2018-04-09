package com.info.controller;


public class Account 
{
	String accountNumber;
	String mobileNumber;

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
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", mobileNumber="
				+ mobileNumber + "]";
	}

	public Account(String accountNumber, String mobileNumber) {
		super();
		this.accountNumber = accountNumber;
		this.mobileNumber = mobileNumber;
	}

}
