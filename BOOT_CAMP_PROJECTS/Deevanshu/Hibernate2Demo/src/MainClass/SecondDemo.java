package MainClass;

import java.util.List;

import org.hibernate.*;

import org.hibernate.cfg.Configuration;

import com.infogain.model.*;


public class SecondDemo {

	
	public static void main(String[] args)
	{
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sFactory = conf.buildSessionFactory();
		Session sess= sFactory.openSession();
		Query query=sess.createQuery("from Employee");
		Query query1=sess.createQuery("from Person");
		
		List<Person> person =query1.list();
		
		List<Employee> employees =query.list();
		for(Person per:person)
		{
			System.out.println(per.getName());
		}
		for(Employee i:employees)
		{
			System.out.println(i.getDesignation());
		}
		
		//Transaction tx= sess.beginTransaction();
		/*sess.save(new Person("Second"));
		sess.save(new Employee("sss","hr",90000));
		sess.save(new Student("Deevanshu","Java",78.0));*/
		
		
		sess.close();
		//sFactory.close();
		System.out.println("Operation Successful");

	}

}
