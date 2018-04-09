package com.infy.model;

import java.util.List;
import java.util.Scanner;

import org.hibernate.*;

public class Admin 
{
	int manf_id; 
	String manf_name;
	Scanner sc = new Scanner(System.in);
	HibernateUtil hiber = new HibernateUtil();
	
	SessionFactory sFactory = HibernateUtil.getSessionFactory();
	Session sess= sFactory.openSession();

	void addItem(int id,String name,int price)
	{
		
		
		Transaction tx= sess.beginTransaction();
		System.out.println("Enter Manufacturer Id");
		manf_id=sc.nextInt();
		System.out.println("Enter Manufacturer name");
		manf_name=sc.next();
		Manufacturer menu = new Manufacturer(manf_id, manf_name);
		Item item = new Item(id,menu,name,price);
		sess.save(item);
		System.out.println("Added succesfully");
		tx.commit();	
		
	}
	
	void deleteItem(int id)
	{
		
		Transaction tx= sess.beginTransaction();
		Item emp2 =(Item) sess.get(Item.class, id);
		System.out.println("The item "+ emp2.getItemName()+ " is deleted");
		sess.delete(emp2);
		tx.commit();
	}
	void searchItem(int id)
	{
	
		Transaction tx= sess.beginTransaction();
		Item emp2 =(Item) sess.load(Item.class, id);
		System.out.println("The Item Name is:"+ emp2.getItemName());
		tx.commit();	
	}

	void showOptions()
	{
		Transaction tx= sess.beginTransaction();
		Query query=sess.createQuery("from Item");
		@SuppressWarnings("unchecked")
		List<Item> item =query.list();
		for(Item i:item)
		{
			System.out.println(i.toString());
		}
		
		tx.commit();
	}
	
	void updateItem(int id)
	{
		int choice,price;
		String name;
		Transaction tx= sess.beginTransaction();
		
		//Adding an item into database
		
		Item emp2 =(Item) sess.load(Item.class, id);
		System.out.println("The Item is:"+ emp2.getItemName());
		System.out.println("Press 1 to update name or 2 to update price");
		choice=sc.nextInt();
		if(choice==1)
		{
			System.out.println("Enter name");
			name=sc.next();
			emp2.setItemName(name);
			
		}
		else if(choice ==2)
		{
			System.out.println("Enter price");
			price=sc.nextInt();
			emp2.setItemPrice(price);
		}
		else
			System.out.println("Wrong Choice");
		

		tx.commit();
		
	}
	
	
}
