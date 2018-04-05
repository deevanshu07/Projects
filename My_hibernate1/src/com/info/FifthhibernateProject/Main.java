package com.info.FifthhibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class Main {

	public static void main(String[] args) {

		// Write the Student object into the database
		// Many to one
		System.out.println("Inserting data into the database");
		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setDetail("J&kk");

		Student student1 = new Student();
		student1.setName("Rishii");
		student1.setStudentAddress(studentAddress);// Imp Step

		Student student2 = new Student();
		student2.setName("Keshavv");
		student2.setStudentAddress(studentAddress);
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// this would save the Students object into the database
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();

		// Bidirectional-One to Many
		System.out.println("****************************");
		StudentAddress studentAddress1 = new StudentAddress();
		studentAddress1.setDetail("Rajouri");

		Student student3 = new Student();
		student3.setName("Govind");
		student3.setStudentAddress(studentAddress1);// Imp Step

		Student student4 = new Student();
		student4.setName("Kunal");
		student4.setStudentAddress(studentAddress1);// Imp Step

		studentAddress1.getStudents().add(student3);
		studentAddress1.getStudents().add(student4);
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		session1.save(studentAddress1);
		session1.getTransaction().commit();
		session1.close();
		sessionFactory.close();
	}
}
