package coding;

public class DuplicateStrings {

	public static void main(String[] args) {

		String duplString = "Deevanshu Mahajan";
		//DuplicateStrings.printDuplicateStrings(duplString);
		DuplicateStrings.duplicateIntegers();
		
		

	}

	static void duplicateIntegers() {
		int arr[] = { 7, 5, 5, 2, 4, 5, 6, 1, 4, 4, 3, 1 };
		int result[] = new int[arr.length];
		int counter=0;
		for (int i = 0; i < arr.length; i++) {
			boolean isDistinct = false;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					isDistinct = true;
					break;
				}
			}
			if(!isDistinct){
				result[counter++]=arr[i];
			}
		}
		int count=1;
		for (int i = 0; i < counter; i++) {
			count=0;
			for (int j = 0; j < arr.length; j++) {
				if(result[i]==arr[j]){
					count++;
				}
			}
			if(count>1)
			System.out.println(result[i] + " = " + count);
		}
		

	}

	//DeevanshuMahajan
	static void printDuplicateStrings(String str) {
		str = str.replace(" ", "");
		String ss = "";
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			ss = ss + str.charAt(i);
			if (!s.contains(ss))
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j)) {
						s = s + str.charAt(j);
						count++;
					}
				}
			if (count > 1) {
				System.out.println( str.charAt(i) + " = "
						+ count);
			}
			ss = "";
		}

	}
}
