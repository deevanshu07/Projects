package coding;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 5, 2, 3, 6, 1 };
		int total = ((array.length + 1) * (array.length + 2)) / 2;
		System.out.println(total);
		for (int i = 0; i < array.length; i++) {
			total -= array[i];
		}
		System.out.println("Missing number=" + total);
	}

}
