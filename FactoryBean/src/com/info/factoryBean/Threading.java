package com.info.factoryBean;

public class Threading implements Runnable{  
 public void run(){ 
	 
  for(int i=1;i<5;i++){  
    try{Thread.sleep(500);}catch(Exception e){System.out.println(e);}  
    System.out.println(Thread.currentThread().getName());  
  }  
 }  
 static Integer i;
 public static void main(String args[]) throws InterruptedException{  
/*  Threading t=new Threading(); 
  Thread t1= new Thread(t);
  Thread t2= new Thread(t);
  Thread t3= new Thread(t);
  t1.setName("First Thread");
  t2.setName("Second Thread");
  t3.setName("Third Thread");
  t1.start(); 
  t2.start();
  t3.start(); */
 

 try{
  int returnValue=doStuff(i);
  System.out.println(returnValue);
 }
 catch(Exception e)
 {
	 
 }
 }  
 
 public static int doStuff(Integer var)
 {
	 int t=12;
	 return t;
 }
}  