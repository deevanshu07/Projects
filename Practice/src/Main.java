import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

class AB {
	public void calculate() throws Exception {
		System.out.println("Calulate");
	}
}

class B extends AB {
	public void calculate() throws IOException {
		System.out.println("Exception");
	}
}

class Child {
	public Child() {
		super();
		// System.out.println("Child constructor called");
	}
}

class A {
	private int id;
	private String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		// System.out.println("Result=" + result);
		// System.out.println("Name hashcode=" + name.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		// System.out.println();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public A(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + "]";
	}

}

class Officer implements Comparable<Officer> {
	String age;
	int salary;

	public Officer(String age, int salary) {
		super();
		this.age = age;
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public int getSalary() {
		return salary;
	}

	public void compare() {

	}

	@Override
	public int compareTo(Officer o1) {

		return 0;
	}

}

class sortingByBoth implements Comparator<Officer> {

	@Override
	public int compare(Officer o1, Officer o2) {
		// TODO Auto-generated method stub

		return 0;
	}
}


class Base{
	public void method(){
		System.out.println("Base method");
	}
}

class Derive extends Base{
	public void method(){
		System.out.println("Derive method");
	}
}
public class Main {

	public static void main(String[] args) throws Exception {

/*		String fileName = "C:\\Users\\deevanshu.mahajan\\Desktop\\data.txt";
		BufferedReader buff = new BufferedReader(new FileReader(fileName));
		String currentLine = "";
		int count = 0;
		StringBuilder build = new StringBuilder();
		while ((currentLine = buff.readLine()) != null) {
			build.append(currentLine + " ");
			count++;
		}

		System.out.println(count);
		System.out.println(build);

		String str = build.toString();
		String[] noOfWords = str.split(" ");
		int charCount = 0;
		System.out.println(noOfWords.length);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				charCount++;
		}
		System.out.println(charCount);*/

		/*
		 * Map<A, String> hashMap = new HashMap<A, String>(); hashMap.put(new
		 * A(101, "Deevanshu"), "employee"); hashMap.put(new A(102, "Mahajan"),
		 * "employee1"); // hashMap.put(new A(103,"Kanica"), "employee2");
		 * //System.out.println(hashMap);
		 * 
		 * 
		 * HashMap<String, Integer> hashMap1 = new HashMap<String, Integer>();
		 * hashMap1.put("deevanshu", 101); hashMap1.put("mahajan", 102);
		 * hashMap1.put("kanica", 103);
		 * 
		 * 
		 * Set<Map.Entry<String, Integer>> ent = hashMap1.entrySet();
		 * Iterator<Entry<String, Integer>> ite = ent.iterator();
		 * 
		 * while(ite.hasNext()){ Entry<String, Integer> entry= ite.next();
		 * if(entry.getKey().equals("deevanshu")) hashMap1.put("FF",
		 * entry.getValue()+20);
		 * 
		 * }
		 * 
		 * System.out.println(hashMap1);
		 * 
		 * 
		 * ArrayList<String> arrayList = new ArrayList<String>();
		 * arrayList.add("Deevanshu"); arrayList.add("Mahajan");
		 * arrayList.add("Kanica");
		 * 
		 * Iterator<String> iter= arrayList.iterator(); while(iter.hasNext()){
		 * if(iter.next().equals("Deevanshu")){ arrayList.add("Deevanh"); } }
		 */
		/*
		 * int number = 4; double t = 0; double squareRoot = number / 2; do { t
		 * = squareRoot; squareRoot = (t + (number / t)) / 2; } while ((t -
		 * squareRoot) != 0);
		 * 
		 * System.out.println(squareRoot); int sqrt = (int) squareRoot;
		 * System.out.println(sqrt);
		 * 
		 * boolean isPrime = true; int numb = 8, temp = 0; for (int i = 2; i <
		 * numb / 2; i++) { temp = numb % i; if (temp == 0) { isPrime = false;
		 * break; } }
		 * 
		 * if (isPrime) { System.out.println("Prime"); } else {
		 * System.out.println("NOT prime"); }
		 */
		
		
	}

	
	static void show(String arg) {
		String str[] = arg.split(" ");
		int arr[] = new int[str.length];

		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	static void mergeList(ArrayList<Bat> arrayList) {
		ArrayList<Bat> finalList = new ArrayList<Bat>();
		boolean flag = false;
		for (int i = 0; i < arrayList.size(); i++) {

			for (int j = i + 1; j < arrayList.size(); j++) {

				if (arrayList.get(j).getHeight() == arrayList.get(i)
						.getHeight()) {
					Bat bat = new Bat(arrayList.get(i).getNoOfBats()
							+ arrayList.get(j).getNoOfBats(), arrayList.get(j)
							.getHeight(), arrayList.get(j).getWidth(),
							arrayList.get(j).getWeight());

					finalList.add(bat);
					flag = true;
					break;
				} else {
					flag = false;
				}
			}

			if (flag == false) {
				finalList.add(new Bat(arrayList.get(i).getNoOfBats(), arrayList
						.get(i).getHeight(), arrayList.get(i).getWidth(),
						arrayList.get(i).getWeight()));
			}

		}

		System.out.println(finalList);
		for (int i = 0; i < finalList.size(); i++) {

			for (Bat bat : finalList) {
				if (bat.getHeight() == 300) {
					finalList.remove(bat);
				}

			}
		}
		System.out.println(finalList);
	}
}
