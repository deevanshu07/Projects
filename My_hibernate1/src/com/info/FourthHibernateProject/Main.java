package com.info.FourthHibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class Main {

	public static void main(String[] args) {
		// One to one example
		// Write the Student_Info object into the database
		System.out.println("Inserting data into the database");
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// this would save the Student_Info object into the database

		Student stu=(Student)session.get(Student.class, 4);
		System.out.println(stu);
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
