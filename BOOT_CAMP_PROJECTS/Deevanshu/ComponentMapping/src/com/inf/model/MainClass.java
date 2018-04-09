package com.inf.model;
import org.hibernate.*;
public class MainClass 
{

	
	public static void main(String[] args)
	{
	
		SessionFactory sFactory=HibernateUtil.getSessionFactory();
		Session sess = sFactory.openSession();
		Transaction tx = sess.beginTransaction();
		Name name1= new Name("Neel","Nitin","Mukesh");
		Employee emp= new Employee(name1,"Programmer",300000);
		sess.save(emp);
		
		tx.commit();
		sess.close();
		/* */
		System.out.println("Operation Successful");
		
		
		

	}

}
