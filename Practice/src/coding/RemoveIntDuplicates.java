package coding;

public class RemoveIntDuplicates {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 2, 5, 7, 8, 2, 3, 5, 6, 7, 1 };
		int arr1[]= new int[arr.length];
		
		arr1[0]=arr[0];
		int m=1;
		
		for(int i=1;i<arr.length;++i){
			if(arr[i-1]!=arr[i]){
				arr1[m]=arr[i];
				++m;
			}
		}
		
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+"\t");
		}
	}
}
