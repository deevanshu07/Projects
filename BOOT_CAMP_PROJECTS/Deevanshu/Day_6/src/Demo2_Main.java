
public class Demo2_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Demo2Thread t1= new Demo2Thread("Its My Thread");
		Demo2Thread t2 = new Demo2Thread("Its not my thread");
		Thread thread = new Thread(t1);
		Thread thread2= new Thread(t2);
		
		thread.start();
		thread2.start();
	}

}
