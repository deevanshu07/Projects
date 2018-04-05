public class ReverseArray {

	public static char[] reverseString(String input) {

		char[] arr = input.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start = start + 1;
			end = end - 1;
		}


		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 12, 9, 5 };
		int start = 0;
		int end = arr.length - 1;
		int temp;
		while (start <= end) {
			if (arr[start] < arr[end]) {
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			start = start + 1;
			end = end - 1;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		String str="Deevanshu Mahajan";
		char []reverse=ReverseArray.reverseString(str);
		for(int i=0;i<reverse.length;i++){
			System.out.print(reverse[i]);
		}
	}

}
