package com.infogain.model;

public class CorporateCustomer extends Customer
{
	int regNo;
	double discountPercent;
	
	public CorporateCustomer(int customerId, String custName, String custDob,String custMobile, String custType, String custAddress) 
	{
		super(customerId,custName,custDob,custMobile,custType,custAddress);
		
	}

	

}
