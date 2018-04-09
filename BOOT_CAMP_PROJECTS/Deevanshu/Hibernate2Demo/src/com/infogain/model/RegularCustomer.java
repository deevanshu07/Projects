package com.infogain.model;

public class RegularCustomer extends Customer 
{
	
	int customerPoints;
	
	public RegularCustomer(int customerId, String custName, String custDob,String custMobile, String custType, String custAddress) 
	{
		super(customerId,custName,custDob,custMobile,custType,custAddress);
		
	}

	

}
