import java.util.Comparator;


public class itemByName implements Comparator<Item> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(Item o1, Item o2) 
	{
		if(o1.itemId  >o2.itemId)
		{
			return 1;
		}
		
		else if(o1.itemId < o2.itemId)
		{
			return -1;
		}
		else
			return 0;
		
	}

}

