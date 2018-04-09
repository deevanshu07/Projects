package com.infy.model;

import java.util.*;
import org.hibernate.*;

public class LoadTest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Trainer Id:");
		int id=in.nextInt();
		SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
		Trainer tr=(Trainer)session.get(Trainer.class,id);
		System.out.println("Trainer Name: "+tr.getName());
		System.out.println("fetch batches");
		Set<Batch> set=tr.getBatches();
		Iterator<Batch> itr=set.iterator();
		System.out.println(
				"Batches of the trainer:");
		while(itr.hasNext())
		{
			Batch batch=itr.next();
	System.out.println(batch.getId()+"\t"+
			batch.getSlot()+"\t"+batch.getBmode());
		}
		
		in.close();
		session.close();
	}

}
