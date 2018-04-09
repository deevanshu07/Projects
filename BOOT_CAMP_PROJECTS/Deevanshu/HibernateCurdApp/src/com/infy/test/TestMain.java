package com.infy.test;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.property.Getter;

import com.infogain.model.*;


public class TestMain 
{

	
	public static void main(String[] args) 
	{
		Configuration conf= new Configuration();
		conf.configure();
		SessionFactory sFactory = conf.buildSessionFactory();
		Session sess= sFactory.openSession();
		
	Transaction tx= sess.beginTransaction();
	
	
//insert
		Employee emp = new Employee(291,"native","Hr",9000);
		sess.update(emp);
		System.out.println("Id generated by hibernate:");
		/*tx.commit();
		sess.close();*/
	
	
	//select and delete	
	/*Employee emp2 =(Employee) sess.get(Employee.class, 102);
		System.out.println(emp2.getName()+"\t"+emp2.getSalary());
		
		
		sess.delete(emp2);*/
		
	
		//update
/*		System.out.println("Proxy is loaded");
		Employee emp2 =(Employee) sess.get(Employee.class, 110);//eager Loading
		
		//Employee emp2 =(Employee) sess.load(Employee.class, 110);//Lazy Loading
		
		System.out.println("Data is being loaded and ID:"+"\t"+emp2.getId());*/
		//System.out.println(emp2.getName()+"\t"+emp2.getSalary());
		
		//Detacched Entity examples
		/*sess.evict(emp2);
		                  
		emp2.setSalary(60000);
		//Merge method to update the detached entity and attached it with the session
		sess.merge(emp2);*/
		
		tx.commit();
		sess.close();
		sFactory.close();
		System.out.println("Operation Successful");
		
		

	}

}
