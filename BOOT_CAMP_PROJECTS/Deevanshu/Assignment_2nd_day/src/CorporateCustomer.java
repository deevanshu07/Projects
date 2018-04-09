
 
 class CorporateCustomer extends Customer
 {
	 public CorporateCustomer (int customerId, String custName, String custDOB,String custMobile, String custType, String custAddress) 
	 {
		
		 super(customerId, custName, custDOB, custMobile, custType, custAddress);
		
	}

	int regNo;
	 float discountPercent;
	 
	 public void calcDiscount(int totalAmount) 
	 {
		 
	 }
 }
 