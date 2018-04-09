package com.infy.model;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class InsertDemo {
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		/*SchemaExport schemaExport = new SchemaExport(HibernateUtil.configuration);
		
		schemaExport.setDelimiter(";");
				schemaExport.setOutputFile(String.format("%s_%s.%s ", new Object[] {"ddl", "ORACLE", "sql" }));
		
		boolean consolePrint = true;
		
		boolean exportInDatabase = false;
		
		schemaExport.create(consolePrint, exportInDatabase);
	*/
		Session session = sf.openSession();
		session.beginTransaction();
		

		HeadOfState hos=new HeadOfState();
		hos.setName("Modi");
		hos.setTitle("PM");
		Country c=new Country();
		c.setName("India");
		c.setHos(hos);	
		
		HeadOfState hos2=new HeadOfState();
		hos2.setName("B.Obama");
		hos2.setTitle("President");
		Country c2=new Country();
		c2.setName("USA");
		c2.setHos(hos2);	
		
		//persisting 2 country objects
		session.save(c);
		session.save(c2);
		

		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");
	}

}
