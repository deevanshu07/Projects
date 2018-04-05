package com.info.apple;

import java.io.IOException;


class java{


}
class app{
	void show() throws IOException{
		
	}
}
class app1 extends app{
	void show() throws NullPointerException{
		
	}
}

public class VolatileTest extends Thread {
	volatile boolean keepRunning = true;

    public void run() {
    	long count=0;
        while (keepRunning) {
        	count++;
        }

        System.out.println("Thread count="+count);
    }
    
    
    public void show() throws IOException{
    	
    }

    public static void main(String[] args) throws InterruptedException, IOException {
    	VolatileTest t = new VolatileTest();
        t.start();
        t.show();
        Thread.sleep(1000);
        t.keepRunning = false;
        System.out.println("keepRunning set to false.");
        
    }
}