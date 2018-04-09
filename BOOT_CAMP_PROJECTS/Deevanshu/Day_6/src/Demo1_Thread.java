
public class Demo1_Thread extends Thread
{
	String name;
	public Demo1_Thread( String name) 
	{
		super();
		this.name=name;
		  setDaemon(true);
		
	}
	@Override
	public void run() 
	{
		
		for(int i=0;i<10;i++)
		{
			
			System.out.print(Thread.currentThread().getName()+i+"\n");
			System.out.println("Thread Priority="+Thread.currentThread().getPriority());
			Thread.currentThread().setPriority(NORM_PRIORITY+2);
			
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
	
		
		
	}
	
}
