package com.infy.model;

import java.sql.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadTest {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		/*HeadOfState hos=(HeadOfState) session.get(HeadOfState.class,2);
		System.out.println(hos.getCountry().getName());*/
		
		
		Country ct=(Country) session.get(Country.class,1);
		System.out.println(ct.getHos().getName());
		
		
		/*Scanner in=new Scanner(System.in);
		System.out.println("Enter country id:");
		int id=in.nextInt();
		Session session = sf.openSession();
		session.beginTransaction();
		Country c=(Country) session.get(Country.class,id);
		System.out.println("Country Details:");
		System.out.println("country name:"+c.getName());
		HeadOfState hos=c.getHos();
		System.out.println("hos title:"+hos.getTitle()+"hos name:"+hos.getName());		
		System.out.println("enter hos id:");
		int hosId=in.nextInt();
		HeadOfState hos2=(HeadOfState) session.get(HeadOfState.class,hosId);
		System.out.println("Head Of state Details:");
		System.out.println("hos name:"+hos2.getName());
		Country c2=hos.getCountry();
		System.out.println("country name:"+c2.getName());
		session.getTransaction().commit();
*/		session.close();
		System.out.println("successfully performed");
	}

}
