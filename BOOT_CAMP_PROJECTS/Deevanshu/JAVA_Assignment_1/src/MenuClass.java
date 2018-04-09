
public class MenuClass 
{
	
	
		static itemClass itemMenu[]=new itemClass[3];
		
		static
		{	
			//itemMenu[0]=new ItemClass();
			
			itemMenu[0]=new itemClass(1,"Pizza",2);
			itemMenu[1]=new itemClass(2,"Burger",1);
			itemMenu[2]=new itemClass(3,"Beer",3);
		}		
		 void display()
		{
				for (int i = 0; i < itemMenu.length; i++) 
				{
						System.out.println(itemMenu[i].getItemId()+"\t"+itemMenu[i].getItemName()+"\t"+itemMenu[i].getItemPrepTime());
						
				}
			
		
			}
	


}
