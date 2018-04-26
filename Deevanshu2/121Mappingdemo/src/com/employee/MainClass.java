package com.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainClass 
{

	
	public static void main(String[] args) 
	{
		SessionFactory sFactory=HibernateUtil.getSessionFactory();
		Session session=sFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee emp= new Employee("Deevanshu","Programmer",600000);
		person per= new person("akash", 21);
		session.save(per);
		session.save(emp);
		
		
		tx.commit();
		session.close();
		sFactory.close();
		
		System.out.println("Successful");

	}

}
