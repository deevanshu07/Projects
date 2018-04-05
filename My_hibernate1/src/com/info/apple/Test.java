package com.info.apple;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.info.apple.onetoone.Address;
import com.info.apple.onetoone.Student;

interface AB {
	abstract void disp();

	void dis();
}

abstract class A implements AB {
	int a;

	abstract void display();
}

class Course {
	String subject1;
	String subject2;
	String subject3;

	public Course(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}

}

class student implements Cloneable {
	int id;
	String name;
	Course course;

	public student(int id, String name, Course course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

interface ABC {
	int f();
}

interface B {
	int f();
}

class Common implements ABC, B {
	@Override
	public int f() {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		/*
		 * 
		 * Course course = new Course("Physics", "Chemistry", "Biology");
		 * student student1 = new student(101349, "Deevanshu", course); student
		 * student2 = null;
		 * 
		 * student2 = (com.info.apple.student) student1.clone();
		 * System.out.println(student1.course.subject3); System.out.println();
		 * student2.course.subject3 = "Maths";
		 * System.out.println(student1.course.subject3);
		 */
		// TODO Auto-generated method stub
		/*
		 * AnnotationConfiguration configuration = new
		 * AnnotationConfiguration(); configuration.configure(); SessionFactory
		 * factory = configuration.buildSessionFactory(); Session session =
		 * factory.openSession(); Transaction tx = session.beginTransaction();
		 */

		/* Country country= (Country) session.load(Country.class, 30); */

		/*
		 * Map<Integer, String> hashMap = new HashMap<Integer, String>();
		 * hashMap.put(1, "Deevanshu"); hashMap.put(1, "Mahajan");
		 * hashMap.put(2, null); hashMap.put(null, null);
		 * System.out.println(hashMap.put(12, "Deevanshu"));
		 * 
		 * int hashCode = 20121113; int bucket = hashCode & (12 - 1);
		 * System.out.println(bucket);
		 * 
		 * ArrayList<Integer> arrayList = new ArrayList<Integer>();
		 * arrayList.add(1); arrayList.add(2); arrayList.add(3);
		 * arrayList.add(4); arrayList.remove(2); System.out.println(arrayList);
		 * 
		 * Vector<Integer> vec = new Vector<Integer>(); Enumeration enums =
		 * vec.elements(); Iterator ite = arrayList.iterator();
		 * 
		 * HashSet<Integer> hashSet = new HashSet<Integer>(); hashSet.add(1);
		 * hashSet.add(2); hashSet.add(2); System.out.println(hashSet);
		 * 
		 * ConcurrentHashMap<Integer, String> map1 = new
		 * ConcurrentHashMap<Integer, String>(); map1.put(1, "Deevanshu");
		 * map1.put(2, "Mahajan"); map1.putIfAbsent(2, "MMMM");
		 * System.out.println(map1);
		 */
		/*
		 * tx.commit(); session.close();
		 */

		/*
		 * Employee emp= new Employee("Deevanshu", 50000); session.save(emp);
		 */
		/*
		 * session.save(new Person("Deevanshu")); session.save(new
		 * Employeeh("ABC", "IT", 50000)); session.save(new Student("Vinay",
		 * "ITI", 5000));
		 */
		/*
		 * Name name= new Name("Deevanshu", "Mahajan"); Customer cust= new
		 * Customer(name, "Noida", 9000); int
		 * result=(Integer)session.save(cust);
		 * System.out.println("Result is="+result);
		 */
		/*
		 * HeadOfState hos= new HeadOfState("Donald Trump", "President");
		 * Country coun= new Country("USA", hos); int result=(Integer)
		 * session.save(coun); System.out.println("Result is="+result);
		 */
		/*
		 * HeadOfState hos= (HeadOfState) session.load(HeadOfState.class,33);
		 * System.out.println(hos.getCountry().getName());
		 */
		/*
		 * Trainer t1 = new Trainer("Deevanshu"); Trainer t2 = new
		 * Trainer("Vinay"); Batch b1 = new Batch("4-5pm", "Night"); Batch b2 =
		 * new Batch("5-6pm", "Morning"); b1.setTrainer(t1); b2.setTrainer(t2);
		 * session.save(b1); session.save(b2);
		 */
		/*
		 * Batch batch = (Batch) session.get(Batch.class, 40);
		 * System.out.println(batch.getTrainer().getName());
		 */

		/*
		 * Previledge p1 = new Previledge(); p1.setName("bike");
		 * 
		 * Previledge p2 = new Previledge(); p2.setName("car");
		 * 
		 * Previledge p3 = new Previledge(); p3.setName("flat");
		 * 
		 * Employee employee1= new Employee("Deevanshu", "Developer"); Employee
		 * employee2= new Employee("Anil", "Manager"); Employee employee3= new
		 * Employee("Sumeet", "Architect");
		 * 
		 * Set<Previledge> emp_previldges1= new HashSet<Previledge>();
		 * emp_previldges1.add(p1);
		 * 
		 * Set<Previledge> emp_previldges2=new HashSet<Previledge>();
		 * emp_previldges2.add(p2); emp_previldges2.add(p3);
		 * 
		 * Set<Previledge> emp_previldges3=new HashSet<Previledge>();
		 * emp_previldges3.add(p3);
		 * 
		 * employee1.setPreviledges(emp_previldges1);
		 * employee2.setPreviledges(emp_previldges2);
		 * employee3.setPreviledges(emp_previldges3);
		 * 
		 * session.save(employee1); session.save(employee2);
		 * session.save(employee3);
		 */
		/*
		 * Employee employee= (Employee) session.get(Employee.class, 44);
		 * System.out.println(employee.getPreviledges());
		 */

		/*
		 * int arr[]={1,2,3,4}; int arr2[]={3,2,1,4};
		 * 
		 * Arrays.sort(arr2); for (int i = 0,j=0; i < arr2.length; i++,j++) {
		 * 
		 * }
		 * 
		 * 
		 * ArrayList<Employee> emp= new ArrayList<Employee>(); Employee emp1=
		 * new Employee("Deevanshu", "Dev"); Employee emp2= new
		 * Employee("Deevanshu", "Dev"); emp.add(emp1); emp.add(emp2);
		 */

		/*
		 * NavigableMap original = new TreeMap(); original.put(1, "Deevanshu");
		 * original.put(2,"Mahajan"); original.put(3,"Vinay");
		 * original.put(4,"Atul"); System.out.println(original); SortedMap
		 * headMap1= original.subMap(2, 4); System.out.println(headMap1);
		 * HashMap<Integer, String> h= new HashMap<Integer, String>();
		 * Map<Integer, String> map = new HashMap<Integer, String>();
		 * Map<Integer, String> con= new ConcurrentHashMap<Integer, String>();
		 */

		/*
		 * ArrayList<Integer> list = new ArrayList<Integer>(); for (int i = 1; i
		 * < 5; i++) { list.add(new Integer(i)); }
		 * 
		 * System.out.println(list); Collections.shuffle(list);
		 * System.out.println(list);
		 */

		/*
		 * Criteria criteria = session.createCriteria(Employee.class);
		 * ProjectionList projList = Projections.projectionList();
		 * projList.add(Projections.property("name"), "name");
		 * projList.add(Projections.property("salary"), "salary");
		 * criteria.setProjection(projList).setResultTransformer(
		 * Transformers.aliasToBean(Employee.class));
		 */
		/*
		 * Criterion salary = Restrictions.gt("salary", 2000); Criterion name =
		 * Restrictions.ilike("name", "Akash%");
		 * 
		 * LogicalExpression orExp = Restrictions.and(salary, name);
		 * criteria.add(orExp);
		 *//*
			 * criteria.setFirstResult(1); criteria.setMaxResults(3);
			 */

		/*
		 * List list= session .createCriteria(Employee.class) .setProjection(
		 * Projections.projectionList()
		 * .add(Projections.groupProperty("department"))
		 * .add(Projections.max("salary"))).list();
		 */

		/*
		 * Criteria
		 * criteria=session.createCriteria(Employee.class,"emp").createAlias
		 * ("INFO_EMPLOYEE", "emp1");
		 */
		/*
		 * criteria.add(Restrictions.gt("salary", 300000)); ProjectionList
		 * projectList=Projections.projectionList();
		 * projectList.add(Projections.groupProperty("department"));
		 * projectList.add(Projections.max("salary"));
		 * criteria.setProjection(projectList);
		 */

		/*
		 * Employee emp1=new Employee(); emp1.setDepartment("HR");
		 * criteria.add(Example.create(emp1)); List list=criteria.list();
		 * System.out.println(list);
		 */

		/*
		 * List list=criteria.list(); System.out.println(list);
		 */

		
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student student=(Student)session.get(Student.class, 1L);
		System.out.println(student.getStudentAddress());
		
		tx.commit();
		System.out.println("Transaction completed");
		session.close();

	}
}

interface ABCD {
	void disp();

	void total();
}

abstract class Car implements ABCD {
	abstract void sum();
}

abstract class Toy extends Car {

}