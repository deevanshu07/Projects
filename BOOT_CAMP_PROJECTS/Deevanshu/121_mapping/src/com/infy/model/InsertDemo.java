package com.infy.model;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InsertDemo {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Country country= (Country) session.load(Country.class,2);
		
	
		System.out.println("hos is being loaded");
		
		HeadOfState hs=country.getHos();
		
		System.out.println(country.id);
		System.out.println(country.name);
		System.out.println(hs.getName()+"\t"+hs.getTitle());
		
		
		
		

		HeadOfState hos=new HeadOfState();
		hos.setName("N.S.Modi");
		hos.setTitle("PM");
		
		
		Country c=new Country();
		c.setName("India");
		c.setHos(hos);	
		
		HeadOfState hos2=new HeadOfState();
		hos2.setName("B.Obama");
		hos2.setTitle("President");
		
		Country c2=new Country();
		c2.setName("USA");
		c2.setHos(hos2);	
		
		
		//persisting 2 country objects
		session.save(c);
		session.save(c2);
	/*	
		Country country=(Country) session.get(Country.class,3);
		HeadOfState hos=new  HeadOfState();
		hos.setName("Elizabeth");
		country.setName("England");
		country.setHos(hos);*/
		
		

		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");
	}

}
