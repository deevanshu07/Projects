

 abstract class Customer
{
     int customerId;
     String custName;
     String  custDOB ;
     String  custMobile ;
     String custType ;
     String  custAddress;
	
     
     
     
     public Customer(int customerId, String custName, String custDOB,
			String custMobile, String custType, String custAddress) 
    {
		super();
		this.customerId = customerId;
		this.custName = custName;
		this.custDOB = custDOB;
		this.custMobile = custMobile;
		this.custType = custType;
		this.custAddress = custAddress;
	}




	public String getCustType() {
		return custType;
	}




	public void setCustType(String custType) {
		this.custType = custType;
	}




	public int getCustomerId() {
		return customerId;
	}




	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
  
 

 
 class RegularCustomer extends Customer
 {
	 public RegularCustomer(int customerId, String custName, String custDOB, String custMobile, String custType, String custAddress) 
	 {
		super(customerId, custName, custDOB, custMobile, custType, custAddress);
		
	}

	int customerPoints;
	
	 public void  redeemPoints(int points) 
	 {
		 
	 }
     
	 public void  checkPoints()
	 {
		 
	 }
 }
 
 


