package model;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class MainClass {

	
	public static void main(String[] args) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session sess= sessionFactory.openSession();
		Transaction tx= sess.beginTransaction();
	
		
		Book book= new Book(1, "A", "Author1");
		Book book1= new Book(2, "B", "Author2");
		Book book2= new Book(3, "C", "Author3");
		
		sess.save(book);
		sess.save(book1);
		sess.save(book2);
		
		SQLQuery sqlQuery= sess.createSQLQuery("select * from book1");
		
		List<Book> result = sqlQuery.list();
		System.out.println(result);
		
		SQLQuery sqlQuery1= sess.createSQLQuery("update book1 where name=:name");
		sqlQuery.addEntity(Book.class);			//note that addEntity() is method of SQLQuery rather Query
		sqlQuery.setParameter("name", "tester");
		List<Book> result1 = sqlQuery.list();
		System.out.println(result);
		
		SQLQuery sqlQuery2= sess.createSQLQuery("select * from book where name=:name");
		sqlQuery.addEntity(Book.class);			//note that addEntity() is method of SQLQuery rather Query
		sqlQuery.setParameter("name", "Author1");
		List<Book> result2 = sqlQuery.list();
		System.out.println(result);
		
		
		
		tx.commit();
		sess.close();
		System.out.println("Succesfull implementation");
	}

}
