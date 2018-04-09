package com.infy.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class InsertDemo {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		List<String> topics1=new ArrayList<String>();
		topics1.add("Exceptions");
		topics1.add("MultiThreading");
		topics1.add("Collections");
			
		Course c1=new Course("Java",5000,topics1);
		
		List<String> topics2=new ArrayList<String>();
		topics2.add("Servlets");
		topics2.add("Jsp");
		
			
		Course c2=new Course("JEE",10000,topics2);
		
		

		/*List<String> topics1=new ArrayList<String>();
		topics1.add("IOC");
		topics1.add("AOP");
		topics1.add("MVC");
			
		Course c1=new Course("spring",5000,topics1);
		
		List<String> topics2=new ArrayList<String>();
		topics2.add("Mapping");
		topics2.add("Caching");
		
			
		Course c2=new Course("hibernate",5000,topics2);*/
		
		//persisting 2 country objects
		session.save(c1);
		session.save(c2);
		

		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");
	}

}
