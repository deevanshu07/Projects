package com.infy.model;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
public class MainClass
{

	
	public static void main(String[] args)
	{

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
	
		
		
		List<Reply> reply=new ArrayList<Reply>();
		reply.add(new Reply("reply1","abc"));
		System.out.println("Reply1");
		reply.add(new Reply("reply2","def"));
		reply.add(new Reply("reply3","ghi"));
		
			
		Post p1=new Post("posting1",reply);
		
		List<Reply> topics2=new ArrayList<Reply>();
		topics2.add(new Reply("Reply4","ABC"));
		topics2.add(new Reply("Reply5","DEF"));
		
			
		Post p2=new Post("posting2",topics2);
		
		
		session.save(p1);
		session.save(p2);
		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");

	}

}
