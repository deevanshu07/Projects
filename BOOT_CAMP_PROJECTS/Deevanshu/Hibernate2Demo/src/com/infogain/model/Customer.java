package com.infogain.model;

public class Customer {
	int customerId;

	String custName;
	String custDob;
	String custMobile;
	String custType;
	String custAddress;
	public Customer(int customerId, String custName, String custDob,String custMobile, String custType, String custAddress) 
	{
		super();
		this.customerId = customerId;
		this.custName = custName;
		this.custDob = custDob;
		this.custMobile = custMobile;
		this.custType = custType;
		this.custAddress = custAddress;
	}

}
