import javax.xml.bind.DatatypeConverterInterface;


public class IncThread implements Runnable {

	Data data;

 public IncThread(Data data) 
{
	this.data=data;
}

	

	@Override
	public void run() 
	{
		//for(int i=0;i<3;i++)
		{
			data.inc();
			
		System.out.println(data.getValue());}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	

}
