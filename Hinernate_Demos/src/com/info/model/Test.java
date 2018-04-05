package com.info.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class A implements Serializable{

	public void readExternal(ObjectInput arg0) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}



public class Test {
	public Test(String key){
		this.key=key;
	}
	public final String key;
	public static void main(String[] args) {
		
		Map map=System.getProperties();
		map.put(new Test("key"), "value");
		
		/*
		 * AnnotationConfiguration configuration = new
		 * AnnotationConfiguration(); configuration.configure();
		 * 
		 * SessionFactory sessionFactory = configuration.buildSessionFactory();
		 * Session session = sessionFactory.getCurrentSession(); Transaction tx
		 * = session.beginTransaction();
		 * 
		 * User user = (User) session.get(User.class, 104);
		 * 
		 * tx.commit();
		 * 
		 * user.setAge(23); Session session1 =
		 * sessionFactory.getCurrentSession(); Transaction tx1 =
		 * session1.beginTransaction(); User user1 = (User)
		 * session1.get(User.class, 104);
		 * 
		 * session1.merge(user);
		 * 
		 * tx1.commit();
		 */

		/*
		 * Stack<Integer> stack= new Stack<Integer>(); stack.add(12);
		 * stack.add(13); stack.add(14);
		 * 
		 * 
		 * stack.push(4); System.out.println(stack); stack.pop();
		 * System.out.println(stack); Queue<Integer> queue = new
		 * LinkedList<Integer>(); queue.add(1); queue.add(2); queue.add(99);
		 * //System.out.println(queue); queue.poll(); queue.poll();
		 * queue.poll(); queue.poll(); System.out.println(queue);
		 */

		/*
		 * ArrayList<String> arrayList = new ArrayList<String>();
		 * arrayList.add("Deevanshu"); arrayList.add("Prateek");
		 * 
		 * System.out.println(arrayList);
		 * 
		 * 
		 * 
		 * Iterator ite= arrayList.iterator();
		 * 
		 * while (ite.hasNext()) {
		 * 
		 * String str= (String) ite.next(); if(str.equals("Deevanshu")){
		 * arrayList.add(0, "Suman");
		 * 
		 * } }
		 * 
		 * System.out.println(arrayList);
		 */

		/*
		 * ArrayList<Integer> arrayList = new ArrayList<Integer>();
		 * arrayList.add(1); arrayList.add(2); arrayList.add(3);
		 * 
		 * ArrayList<Integer> arrayList1 = new ArrayList<Integer>(arrayList);
		 * System.out.println(arrayList1); Collections.copy(arrayList1,
		 * arrayList); System.out.println(arrayList1);
		 * 
		 * HashMap<Days, Integer> hashMap= new HashMap<Test.Days, Integer>();
		 * hashMap.put(Days.MONDAY, 1); System.out.println(hashMap);
		 * 
		 * EnumMap<Days, Integer> enums= new EnumMap<Days, Integer>(Days.class);
		 * enums.put(Days.MONDAY, 1); System.out.println(enums);
		 */
		
		Set<Integer> hashSet= new HashSet<Integer>();
		

	}

	/*
	 * enum Days { MONDAY, TUESDAY; };
	 */

}
