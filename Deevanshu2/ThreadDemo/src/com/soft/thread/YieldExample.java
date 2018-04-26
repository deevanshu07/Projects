package com.soft.thread;

public class YieldExample
{
   public static void main(String[] args)
   {
      Thread producer = new Producer();
      Thread consumer = new Consumer();
       
      producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
      consumer.setPriority(Thread.MIN_PRIORITY); //Max Priority
       
      producer.start();
      consumer.start();
   }
}
 
class Producer extends Thread
{
   public void run()
   {
      for (int i = 0; i < 2; i++)
      {
         System.out.println("I am Producer : Produced Item " + i);
         try 
         {
			Thread.sleep(10000);
		} 
         catch (InterruptedException e) 
         {
			
			e.printStackTrace();
		}
        /*Thread.yield();*/
      }
   }
}
 
class Consumer extends Thread
{
   public void run()
   {
      for (int i = 0; i < 2; i++)
      {
         System.out.println("I am Consumer : Consumed Item " + i);
         try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /* Thread.yield();*/
      }
   }
}