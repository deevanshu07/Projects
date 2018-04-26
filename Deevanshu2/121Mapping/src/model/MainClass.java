package model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class MainClass 
{

	
	public static void main(String[] args) 
	{
		SessionFactory sFactory=HibernateUtil.getSessionFactory();
		Session session=sFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee emp= new Employee("abcd","jjj",21000);
		session.save(emp);
		
		SQLQuery sqlquery=session.createSQLQuery("select * from employee_table");
		sqlquery.addEntity(Employee.class);
		List<Employee> result=sqlquery.list();
		System.out.println(result);
		
		Query q2 = session.createQuery("update Employee e set e.name='dee' where e.id=:id1");
		q2.setString("id1", "1");
		int row = q2.executeUpdate();
		System.out.println("records updated :" + row);
		
		
		//Native
		SQLQuery q3=session.createSQLQuery("select * from employee_table e where e.emp_id=:id2");
		q3.addEntity(Employee.class);
		q3.setString("id2","1");
		
		List<Employee> list=q3.list();
		System.out.println(list);
		
		
		tx.commit();
		session.close();
		sFactory.close();
		
		System.out.println("Successful");
	}

}
