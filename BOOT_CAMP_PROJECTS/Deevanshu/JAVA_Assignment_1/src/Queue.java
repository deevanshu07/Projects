import java.util.*;





public class Queue 
{
	itemClass item = new itemClass();
	Date date = new Date();
	int j=item.getItemId();
	void get(int i)
	{
		
		for(int z=0;z<3;z++)
		{
			j=item.getItemId();
			if(z==j)
				break;
		}
		if(i==j)
		{
		System.out.println("item is ready");
				
			}
		else 
			System.out.println("item is under process");
	}
		

}