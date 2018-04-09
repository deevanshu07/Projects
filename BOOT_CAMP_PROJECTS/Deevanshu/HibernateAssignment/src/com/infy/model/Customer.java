package com.infy.model;

public class Customer {
	
	int customerId;
	String custName;
	String custDob;
	String custMobile;
	String custType;
	String custAddress;

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custName=" + custName
				+ ", custDob=" + custDob + ", custMobile=" + custMobile
				+ ", custType=" + custType + ", custAddress=" + custAddress
				+ "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustDob() {
		return custDob;
	}

	public void setCustDob(String custDob) {
		this.custDob = custDob;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

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

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
