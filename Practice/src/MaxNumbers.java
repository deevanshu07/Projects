import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class MaxNumbers {

	public static void main(String[] args) {
		int array[]={1,4,6,88,13,55,90};
		int maxOne=0, maxTwo=0;
		for(int i=0;i<array.length;i++){
			if(maxOne<array[i]){
				maxTwo=maxOne;
				maxOne=array[i];	
			}
			else if(maxTwo<array[i]){
				maxTwo=array[i];
			}
		}
		
		System.out.println(maxOne);
		System.out.println(maxTwo);
		
		String st="0tring";
		if(st.matches(".*[0-9].*")){
			System.out.println(st);
		}
		
		String str1="This is java program";
		String []chStrings=str1.split(" ");
		//System.out.println(chStrings.length);
		
		HashMap<Integer, String> hash = new HashMap<Integer, String>();
		hash.put(1, "DDD");
		hash.put(2, "KKK");
		hash.put(3, "GGG");
		
		Set<Map.Entry<Integer, String>> enterSet= hash.entrySet();
		Iterator<Entry<Integer, String>> ite= enterSet.iterator();
		while(ite.hasNext()){
			Entry<Integer, String> entry=ite.next();
			if(entry.getKey()==1){
				hash.put(77, "FFFF");
			}
		}
		
		System.out.println(hash);
		
	}
}
