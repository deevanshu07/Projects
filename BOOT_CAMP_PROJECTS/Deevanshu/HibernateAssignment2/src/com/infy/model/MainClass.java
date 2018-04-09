package com.infy.model;
import org.hibernate.*;
public class MainClass
{

	
	public static void main(String[] args)
	{

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session sess= sessionFactory.openSession();
		Transaction tx= sess.beginTransaction();
		
		Reply reply = new Reply();
		reply.setReplyname("reply3");
		Post post = new Post();
		post.setPostName("post2");
		post.setReply(reply);
		sess.save(post);
		
		
		
		tx.commit();
		sess.close();

	}

}
