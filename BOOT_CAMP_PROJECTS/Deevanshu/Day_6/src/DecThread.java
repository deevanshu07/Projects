

public class DecThread implements Runnable {

	

Data data;


	

	@Override
	public void run() 
	{
		//for(int i=0;i<3;i++)
		{
			data.dec();	
			System.out.println(data.getValue());}
		
	}
	public DecThread(Data data) {
		super();
		this.data=data;
		// TODO Auto-generated constructor stub
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	

}

