package coding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable{

	int i;
	public B b;

	public A(int i, B b) {
		this.i = i;
		this.b = b;
	}

	public A() {
		System.out.println("A constructor called");
	}

	@Override
	public String toString() {
		return "A [i=" + i + ", b=" + b + "]";
	}
}

class B implements Serializable{
	int j;

	public B(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "B [j=" + j + "]";
	}

}

public class TwoMaxNumbers {
	public static void main(String[] args) throws Exception {

		B b = new B(20);
		A a = new A(10, b);

		String fileName = "data.txt";
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(file);

		out.writeObject(a);
		System.out.println("Object Serialized");

		FileInputStream file1= new FileInputStream(fileName);
		ObjectInputStream in= new ObjectInputStream(file1);
		A a1=(A)in.readObject();
		System.out.println(a1);
		

	}
}
