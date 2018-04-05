public class BinarySearch {
	public static int binarySearch(int[] inputArray, int key) {
		int start=0;
		int end=inputArray.length-1;
		while(start<=end){
			int mid=(start+end)/2;
			if(key==inputArray[mid])
				return mid;
			if(key<inputArray[mid]){
				end=mid-1;
			}
			
			else{
				start=mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 5, 6, 9, 13, 45 };

		int elemPosition=BinarySearch.binarySearch(arr, 1);
		System.out.println("Element is present at index= "+elemPosition);
		
	}
}
