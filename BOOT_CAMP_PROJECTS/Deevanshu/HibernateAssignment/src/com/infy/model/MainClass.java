package com.infy.model;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.loader.custom.ScalarReturn;



public class MainClass {

	
	public static void main(String[] args) 
	{
		int select;
		Scanner sc = new Scanner(System.in);
		String choice=null;
		
		do
		{
		System.out.println("Welcome ");
		System.out.println("Choose the following Operations");
		System.out.println("1. Show Menu");
		System.out.println("2. Add an Item");
		System.out.println("3. Update an Item ");
		System.out.println("4. Search an Item");
		System.out.println("5. Delete an Item");
		System.out.println("6. Add a new Customer");
		System.out.println("7. Update a Customer");
		System.out.println("8. Delete a Customer");
		System.out.println("9. Search a Customer");
		Admin admin= new Admin();
		AddCustomer add = new AddCustomer();
		
		
		select=sc.nextInt();
		int id,price;
		String name;
		switch(select)
		{
		case 1:
				admin.showOptions();
				break;
		case 2:
			
			System.out.println("Enter id:");
			id=sc.nextInt();
			System.out.println("Enter name:");
			name=sc.next();
			System.out.println("Enter price:");
			price=sc.nextInt();
			admin.addItem(id, name, price);
			break;
			
		case 3: 
				System.out.println("Enter the id to update:");
				
				id=sc.nextInt();
				admin.updateItem(id);
				break;
		case 4:
				System.out.println("Enter The id to search the item");
				id=sc.nextInt();
				admin.searchItem(id);
			break;
		case 5:
			System.out.println("Enter The id to delete the item");
			id=sc.nextInt();
			admin.deleteItem(id);
			break;	
		case 6:
			 
				add.add();
			 break;
			
		case 7: 
				add.update();
				
				break;
		case 8:
				System.out.println("Enter id to delete the customer");
				id=sc.nextInt();
				add.delete(id);
		case 9:
				System.out.println("Enter id to search the customer");
				id=sc.nextInt();
				add.search(id);
				break;
		
		default: System.out.println("Wrong choice");
		continue;
			
		
		}
		System.out.println("Enter y to continue or n to exit");
		
		choice = sc.next();
		}while(choice=="y" || choice!="Y");
		
		
		
		

	}

}
