package com.info.apple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

interface superInterface {
	public void display();

	abstract void disp();
}

abstract class calculate {
	abstract void display();

	public void disp() {
	}
}

class superClass {
	int i = 11;

	void display() throws NullPointerException {
		System.out.println("Displaying");
	}
}

class subClass extends superClass {
	int i = 10;

	public void display() throws NullPointerException {
		System.out.println("Displying");
	}

}

public class Sample1 {
	public static void main(String[] args) throws Exception {
		superClass sup = new subClass();
		sup.display();
		System.out.println(sup.i);

		Employee emp = new Employee(101349, "Deevanshu",24);
		FileOutputStream fout = new FileOutputStream("employee.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(emp);
		out.flush();
		System.out.println("success");
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("employee.txt"));  
		 Employee s=(Employee)in.readObject();  
		 System.out.println(s);

	}
}
