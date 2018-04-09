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

		
		List<Topic> topics1=new ArrayList<Topic>();
		topics1.add(new Topic("IOC",25));
		topics1.add(new Topic("AOP",25));
		topics1.add(new Topic("MVC",50));
			
		Course c1=new Course("spring",5000,topics1);
		
		List<Topic> topics2=new ArrayList<Topic>();
		topics2.add(new Topic("Mapping",70));
		topics2.add(new Topic("HQL",30));
		
			
		Course c2=new Course("hibernate",5000,topics2);
		
		//persisting 2 country objects
		session.save(c1);
		session.save(c2);
		

		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");
	}

}
