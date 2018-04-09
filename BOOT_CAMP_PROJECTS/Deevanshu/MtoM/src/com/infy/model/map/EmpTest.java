package com.infy.model.map;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infy.model.HibernateUtil;

public class EmpTest {
	public static void main(String[] args) {
		
		try {

	        SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        Transaction tx=session.beginTransaction();
	        Employee emp=new Employee();
	        emp.setEname("Dazy");
	        HashMap<String,String> benefits = new HashMap<String,String>();
	        benefits.put("first", "car");
	        benefits.put("second", "flat");
			emp.setBenefit(benefits);
			session.save(emp);     
			
			Employee emp2 = (Employee)session.
			load(Employee.class, new Integer(emp.getEmployeeId()));
			Map map2=emp2.getBenefit();
			System.out.println(map2.get("first"));
			System.out.println(map2.get("second"));
			
			tx.commit();
			session.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}

}
