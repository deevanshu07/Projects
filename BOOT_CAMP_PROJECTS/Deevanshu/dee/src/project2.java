import java.io.*;


class FileReader1
{
	public static void main(String[] args) 
	{
		int array[] = new int[8];
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee1.txt"));
	
				String splitFile="";
				String[] splitValue;
				
				while(true)
				{
					splitFile=bufferreader.readLine();
					splitValue= splitFile.split(",");
					
					for(int i=0;i<4;i++)
					{
						System.out.print(splitValue[i]);
					}
					
				}
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}