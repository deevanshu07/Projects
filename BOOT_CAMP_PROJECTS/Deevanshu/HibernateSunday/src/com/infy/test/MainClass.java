package com.infy.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.info.model.Employee;



public class MainClass {

	public static void main(String[] args) 
	{
	
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sFactory = conf.buildSessionFactory();
		Session sess= sFactory.openSession();
		Transaction tx = sess.beginTransaction();
		Employee emp = new Employee(291,"native","Hr",9000);
		sess.update(emp);
		Employee empp = new Employee(290,"native","Hr",9000);
		sess.update(empp);
		
	
		tx.commit();
		sess.close();
		sFactory.close();
		
	}

}
