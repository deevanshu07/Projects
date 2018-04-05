package com.info.model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ThreadMethod implements Runnable {

	@Override
	synchronized public void run() {
		System.out.println("Thread started ="
				+ Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Ends =" + Thread.currentThread().getName());
	}

}

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {

		/*
		 * ThreadMethod obj = new ThreadMethod(); Thread t1 = new Thread(obj);
		 * t1.setName("one"); Thread t2 = new Thread(obj); t2.setName("two");
		 * Thread t3 = new Thread(obj); t3.setName("three"); t1.start();
		 * t2.start(); t3.start(); t1.start();
		 */
		StringBuffer buff = new StringBuffer();
		buff.append("D");
		buff.append("E");
		System.out.println(buff);

		StringBuilder build = new StringBuilder();
		build.append("D");
		build.append("E");
		System.out.println(build);

		long startTime = System.currentTimeMillis();
		concatStringBuffer();
		System.out.println(System.currentTimeMillis() - startTime);
		startTime = System.currentTimeMillis();
		concatString();
		System.out.println(System.currentTimeMillis() - startTime);
		startTime = System.currentTimeMillis();
		concatStringBuilder();
		System.out.println(System.currentTimeMillis() - startTime);
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> string : hashmap.entrySet()) {

		}
		
		String str= "Deevanshu";
		str.substring(1, 3);
		System.out.println(str.substring(1, 3));
		
StringBuffer buff2= new StringBuffer("DEEVANSHU");
StringBuffer buff1= new StringBuffer("DEEVANSHU");
System.out.println(buff1.equals(buff2));
		
	}

	static String concatString() {
		String t = "Java";
		for (int i = 0; i < 10000; i++) {
			t = t + "Tpoint";
		}
		return t;
	}

	static String concatStringBuffer() {
		StringBuffer t = new StringBuffer("Java");
		for (int i = 0; i < 10000; i++) {
			t = t.append("Tpoint");
		}
		return t.toString();
	}

	static String concatStringBuilder() {
		StringBuilder t = new StringBuilder("Java");
		for (int i = 0; i < 10000; i++) {
			t = t.append("Tpoint");
		}
		return t.toString();
	}
}
