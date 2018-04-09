
public class Demo2Thread implements Runnable{

	
	String name;
	public Demo2Thread(String name) 
	{super();
		 setDaemon(true);
		
	}
	private void setDaemon(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() 
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("This is my thread"+i+name+"\n");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


}
