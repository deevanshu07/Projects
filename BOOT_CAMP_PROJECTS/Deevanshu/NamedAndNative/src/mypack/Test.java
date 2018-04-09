package mypack;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import java.util.*;

import org.hibernate.*;
public class Test {
	static SessionFactory sf;
static Session sess;
	static
{
try
{
sf=HibernateSessionFactory.getSessionFactory();
sess=sf.openSession();
}catch(Exception e){}
}
	public static void main(String g[])
	{
		Transaction tx=sess.beginTransaction();
		
		
		
		//Named Query.....
		
		
				Query qr=sess.getNamedQuery("getAllEmp");
				List<Emp> l=qr.list();
				for (Emp emp : l) {
					System.out.println(emp);
				}
				
		
		/*	Query qr=sess.getNamedQuery("findEmployeeByName");
		qr.setParameter("name","aman");
		List<Emp> l=qr.list();
		for (Emp emp : l) {
			System.out.println(emp);
		}*/
		
		//native sql Query..... 
		
		SQLQuery sqlQuery= sess.createSQLQuery("select * from hbr_emp e where e.job = :job");
		sqlQuery.addEntity(Emp.class);			//note that addEntity() is method of SQLQuery rather Query
		sqlQuery.setParameter("job", "tester");
		List<Emp> result = sqlQuery.list();
		System.out.println(result);
		
    
		
		
		tx.commit();
		sess.close();
		sf.close();
		System.out.println("ok...");
	}
}








