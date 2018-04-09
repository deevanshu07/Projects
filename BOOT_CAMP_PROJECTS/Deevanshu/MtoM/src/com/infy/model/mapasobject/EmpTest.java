package com.infy.model.mapasobject;

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
	        Employee sp = new Employee();
	        Employee sp3 = new Employee();
	        sp.setName("John Doe");
	        HashMap p = new HashMap();
	        p.put("health", new Benefit(200));
	        p.put("dental", new Benefit(300));
	        sp.setBenefits(p);
	        sp3.setName("Jim Smith");
	        sp3.setBenefits(p);
	       
	        session.save(sp);
	        session.save(sp3);
	        session.flush();
	        Employee sp2 = (Employee)session.load(Employee.class, new
	        Integer(sp.getId()));
	        Map p2 = sp2.getBenefits();
	        System.out.println(((Benefit)p2.get("health")).getCost());
	        System.out.println(((Benefit)p2.get("dental")).getCost());
	       
	        tx.commit();
	        session.close();
	        } catch (Exception e) {
	        e.printStackTrace();
	        }
	 }
}