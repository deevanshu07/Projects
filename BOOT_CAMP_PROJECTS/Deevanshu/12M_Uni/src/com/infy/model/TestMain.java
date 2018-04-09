package com.infy.model;
 
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
public class TestMain {
 
    public static void main(String[] args) {
 
    	SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session sess = sf.openSession();
	    Transaction tx=sess.beginTransaction();
    	Batch batch1=new Batch("2 to 4","weekdays");
		Batch batch2=new Batch("4 to 6","weekend");
		Set<Batch> list=new HashSet<Batch>();
		list.add(batch1);
		list.add(batch2);
		
		
		
		Trainer trainer=new Trainer("ryan",list);
		
		Batch batch3=new Batch("1 to 2","weekdays");
		Batch batch4=new Batch("3 to 5","weekend");
		Batch batch5=new Batch("6 to 8","weekend");
		Set<Batch> list2=new HashSet<Batch>();
		
		list2.add(batch3);
		list2.add(batch4);
		list2.add(batch5);
		Trainer trainer2=new Trainer("dazy",list2);
		sess.save(trainer);
		sess.save(trainer2);
		
		tx.commit();
		sess.close();
		System.out.println("Successfully saved.");
    }
}