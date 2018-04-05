package com.info.apple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;




public class Test {
	public static int gcd(int a, int b) 
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
	public static void main(String[] args) throws IOException {
	
		Collection<Integer> integerCollection= new HashSet<Integer>();
		
		
		List<Integer> arrayList= new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(23);
		arrayList.add(null);
		arrayList.add(123);
		arrayList.add(14);
		for (Integer integer : arrayList) {
			System.out.println();
		}
		Vector<Integer> vector= new Vector<Integer>();
		vector.add(1);
		vector.add(2);
		vector.add(3);
		Set<Integer> set=  new TreeSet<Integer>();
		Queue<String> queue= new PriorityQueue<String>();
		
		
		set.add(3);
		set.add(null);
		//System.out.println(set);
		arrayList.add(43);
		arrayList.add(5);
		
		//System.out.println(arrayList);
		
		integerCollection.add(2);
		integerCollection.add(001);
		//System.out.println(integerCollection);
		
		for (Integer obj : arrayList) {
			
			obj.reverse(2);
			System.out.println(obj);
		}
		@SuppressWarnings("rawtypes")
		Iterator ite= arrayList.iterator();
		while (ite.hasNext()) {
			
			int i= (int) ite.next();
			if(i==3){
				ite.remove();
			}
			//System.out.println(i);
			
		}
		
		//System.out.println(arrayList);
		// TODO Auto-generated method stub
		/*
		 * AnnotationConfiguration configuration = new
		 * AnnotationConfiguration(); configuration.configure();
		 * System.out.println(configuration.configure()); SessionFactory factory
		 * = configuration.buildSessionFactory(); Session session =
		 * factory.openSession(); Sample burger = new Sample("burger");
		 * Transaction tx = session.getTransaction(); Query query =
		 * session.getNamedQuery("getAllSample"); List allEmployees =
		 * query.list(); System.out.println(allEmployees); tx.begin();
		 * tx.commit(); session.close();
		 */
		/*
		 * int arg[] = { 5, 6, 8, 9, 10 }; int arr[]=new int[arg.length-1]; //
		 * Delete the Array Element position
		 * 
		 * for (int i = 0, j=0; i < arg.length; i++, j++) {
		 * 
		 * if(arg[i]==6){
		 * 
		 * i++; } if(j<arr.length) arr[j]=arg[i];
		 * 
		 * }
		 * 
		 * 
		 * for (int i = 0; i < arr.length; i++) { System.out.println(arr[i]); }
		 */

		
		int arr[]={1,2,3,4,5,6,7,8,9,10,11,12};
		
		int greatestFactor=Test.gcd(12, 4);
		int i,j,k,temp;
		for (i = 0; i < greatestFactor; i++) {
			temp=arr[i];
			j=i;
			while (1!=0) {
				k=j+4;
				
				if(k>=12)
					k=k-12;

				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
			
		}
		
		for (int l = 0; l < arr.length; l++) {
			//System.out.print(arr[l]+"\t");
			
		}
		
	    
		
	    
		
	    
	    
	}

}
