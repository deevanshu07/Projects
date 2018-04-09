package com.infy.model;



public class CorporateCustomer extends Customer
{
	int regNo;
	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	double discountPercent;
	
	public CorporateCustomer(int customerId, String custName, String custDob,String custMobile, String custType, String custAddress,
			int regNo,double discountPercent) 
	{
		super(customerId,custName,custDob,custMobile,custType,custAddress);
		this.regNo=regNo;
		this.discountPercent=discountPercent;
		
	}

	public CorporateCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
