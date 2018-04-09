package com.infy.model;

import java.util.Scanner;

import org.hibernate.*;


public class AddCustomer 
{
	HibernateUtil hiber = new HibernateUtil();
	SessionFactory sFactory = HibernateUtil.getSessionFactory();
	Session sess= sFactory.openSession();
	Scanner sc = new Scanner(System.in);
	int customerId,checkPoints,regNo,choice;
	double discountPercent;
	String custName, custDob,custMobile,custType,custAddress;
	
	
	void add()
	{
		
		Transaction tx= sess.beginTransaction();
		System.out.println("Enter the Id of Customer");
		customerId=sc.nextInt();
		System.out.println("Enter Customer Name");
		custName=sc.next();
		System.out.println("Enter the Customer Date of Birth");
		custDob=sc.next();
		System.out.println("Enter the Customer Mobile number");
		custMobile=sc.next();
		System.out.println("Enter the customer type r for regular , c for corporate");
		custType=sc.next();
		System.out.println("Enter customer Address");
		custAddress=sc.next();
		
		if(custType.equalsIgnoreCase("r"))
		{
			System.out.println("You are a regular Customer");
			System.out.println("Enter checkpoints");
			checkPoints=sc.nextInt();
			RegularCustomer regular = new RegularCustomer(customerId, custName, custDob, custMobile, custType, custAddress,checkPoints);
			sess.save(regular);
		}
		
		else if(custType.equalsIgnoreCase("c"))
		{
			System.out.println("You are a Corporate Customer");
			System.out.println("Enter regno");
			regNo=sc.nextInt();
			System.out.println("Enter discount percent");
			discountPercent=sc.nextDouble();
			CorporateCustomer corporate = new CorporateCustomer(customerId, 
					custName, custDob, custMobile, custType, custAddress,regNo,discountPercent);
			sess.save(corporate);
		}
		
		System.out.println("Customer Added");
		tx.commit();
	}

	void update()
	{
		
		Transaction tx= sess.beginTransaction();
		System.out.println("Enter 1 to update regular and 2 to update corporate");
		choice=sc.nextInt();
		if(choice==1)
		{
		System.out.println("Enter Customer Id to update");
		customerId=sc.nextInt();
		RegularCustomer regular=(RegularCustomer)sess.get(RegularCustomer.class, customerId);
		System.out.println("Name of Customer is"+ regular.getCustName());
		System.out.println("Enter to change name of customer");
		custName=sc.next();
		regular.setCustName(custName);
		}
		if(choice==2)
		{
			System.out.println("Enter Customer Id to update");
			customerId=sc.nextInt();
			CorporateCustomer regular=(CorporateCustomer)sess.load(CorporateCustomer.class, customerId);
			System.out.println("Name of Customer is"+ regular.getCustName());
			System.out.println("Enter to change name of customer");
			custName=sc.next();
			regular.setCustName(custName);
		}
		
		tx.commit();
	
	}
	
	
	void search(int id)
	{
		Transaction tx= sess.beginTransaction();
		Customer customer =(Customer) sess.load(Customer.class, id);
		System.out.println("The Item Name is:"+ customer.toString());
		tx.commit();
	}
	
	void delete(int id)
	{
		
		Transaction tx= sess.beginTransaction();
		Customer customer =(Customer) sess.get(Customer.class, id);
		System.out.println("The item "+ customer.getCustName()+ " is deleted");
		sess.delete(customer);
		tx.commit();
		
	}

}
