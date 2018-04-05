package coding;

public class DecimalToBinary {
	public static void main(String[] args) {

		int num = 124;
		int arr[] = new int[100];
		int count = 0;
		while (num >0) {
			arr[count++] = num % 2;
			num=num/2;
		}
		for (int i = count-1; i >=0; i--) {
			System.out.print(arr[i]);
		}
		
		System.out.println();
		System.out.println(Integer.toBinaryString(124));
	}

}
