
public class Main1_Thread {

	
	public static void main(String[] args) 
	{
		
		
		Demo1_Thread t1 = new Demo1_Thread("One");
		Demo1_Thread t2 = new Demo1_Thread("Two");
		
		t1.setName("My Thread Deevanshu");
		t2.setName("My Thread Deevansh");
		t1.start();
		
		t2.start();
		for(int i=10;i>0;i--)
		{
			
		
		try {
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("This is my Main");
	}

}
