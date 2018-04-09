package com.infy.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.infy.model.Employee;
import com.infy.model.Person;
import com.infy.model.Student;

public class TestMain {
	public static void main(String[] args) 
	{
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sFactory=conf.buildSessionFactory();
		Session sess=sFactory.openSession();
		
		Transaction tx=sess.beginTransaction();		
		sess.save(new Person("memo"));
		sess.save(new Employee("David","SoftSkill Trainer",3000));
		sess.save(new Student("zacob","Java",1500));	
			
		tx.commit();		
		sess.close();	
		sFactory.close();
	}

}











