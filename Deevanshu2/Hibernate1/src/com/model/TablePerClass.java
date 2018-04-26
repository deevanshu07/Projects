package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TablePerClass 
{

	
	public static void main(String[] args) 
	{
		SessionFactory sFactory=HibernateUtil.getSessionFactory();
		Session session=sFactory.openSession();
		Transaction tx=session.beginTransaction();
	
		Employee emp= new Employee(2,"Naveen","HR","40000");
		person per= new person("abcd","21");
		
		session.save(emp);
		session.save(per);
		
		tx.commit();
		session.close();
		

	}

}
