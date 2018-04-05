package com.info.apple;

abstract class myClass2 {
	public void show() {

	}
}

interface myClass1 {

}

class Base {

	public void show() {

		System.out.println("Deevanshu");
	}
}

class Derived extends Base {

	public void show() {
		super.show();
		System.out.println("Akash");
	}

}

class DerivedFrom extends Derived {
	public void show() {
		super.show();
		System.out.println("Sanyam");
	}
}

public class Inheritence {

	public static void doPrint(Base b) {
		b.show();
	}
	public static void main(String[] args) {
		/*
		 * DerivedFrom from = new DerivedFrom(); from.show();
		 * out.println("GeeksforGeeks");
		 */
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		/*
		 * System.out.println("Rotating elements"); int howMany; Scanner sc= new
		 * Scanner(System.in); System.out.println("Enter how many rotations=");
		 * howMany=sc.nextInt();
		 * 
		 * int temp[]=new int[howMany]; for (int i = 0; i < temp.length; i++) {
		 * temp[i]=arr[i]; }
		 */
		int pos = 3;
		for (int i = 0; i < arr.length; i++) {
			if (pos == i)
				for (int j = i + 1; i < arr.length; j++) {
					arr[i] = arr[j];
					i++;
				}
		}

		for (int i = 0; i < arr.length; i++) {

		}

	}

}
