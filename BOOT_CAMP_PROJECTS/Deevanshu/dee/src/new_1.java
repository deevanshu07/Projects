import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


class new_1
{
	public static void main(String[] args)
	{
		
		
		try
		{
		BufferedReader br =new BufferedReader(new FileReader("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee1.txt"));
		int arr[]= new int[6];

String b=" ";
for (int i = 0; i < arr.length; i++)
{
 
b=br.readLine();
String k=b.substring(0,b.indexOf(","));
b=b.substring(b.indexOf(",")+1);
String m=b.substring(0,b.indexOf(","));
b=b.substring(b.indexOf(",")+1);
String n=b.substring(0,b.indexOf(","));
String p=b.substring(b.indexOf(",")+1);



System.out.print(k);
System.out.print(m);
System.out.print(n);
System.out.print(p);

    
 /*   arr[i].itemId=Integer.parseInt(k);
    arr[i].itemName=m;
    arr[i].itemPrepTime=Integer.parseInt(n);
    arr[i].itemCost=Integer.parseInt(p);
    
    System.out.print(arr[i].itemId+" ");
    System.out.print(arr[i].itemName+" ");
    System.out.print(arr[i].itemCost+" ");
    System.out.println(arr[i].itemPrepTime);*/


}
br.close();
} 
	
	catch (Exception e) 
{
 e.printStackTrace();
}
}}
