package com.info.apple;


class base1<T>{
	private T t;

	@Override
	public String toString() {
		return "base1 [t=" + t + "]";
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class base2{
	private Object t;

	@Override
	public String toString() {
		return "base2 [t=" + t + "]";
	}

	public Object getT() {
		return t;
	}

	public void setT(Object t) {
		this.t = t;
	}
}

public class Generics {

	public static void main(String[] args) {
		
		base1 b= new base1();
		b.setT("Deevanshu");
		System.out.println(b);
		
		String str=(String) b.getT();
		
		base2 b2= new base2();
		b2.setT("Deevanshu");
		b2.setT(10);
		String str1=(String) b2.getT();
		System.out.println(str1);
		
	}
}
