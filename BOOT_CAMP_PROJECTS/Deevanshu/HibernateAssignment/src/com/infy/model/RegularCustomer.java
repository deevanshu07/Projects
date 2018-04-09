package com.infy.model;

public class RegularCustomer extends Customer 
{
	
	int customerPoints;
	
	
	
	public RegularCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerPoints() {
		return customerPoints;
	}

	public void setCustomerPoints(int customerPoints) {
		this.customerPoints = customerPoints;
	}

	public RegularCustomer(int customerId, String custName, 
			String custDob,String custMobile, String custType, 
			String custAddress,int customerPoints) 
	{
		super(customerId,custName,custDob,custMobile,custType,custAddress);
		this.customerPoints=customerPoints;
		
	}
	
	

	

}
