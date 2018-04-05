package coding;
public class ReverseString {
	public static void main(String[] args) {
		String str = "This is hidden";
		
		System.out.println(str.length());
		StringBuffer buff = new StringBuffer();
		String[] array = str.split(" ");
		for (int i = 0; i < array.length; i++) {

			int count = array[i].length();
			String str1 = array[i].toString();
			for (int j = count - 1; j >= 0; j--) {
				buff.append(str1.charAt(j));
			}
			buff.append(" ");
		}
		buff.deleteCharAt(str.length());
		System.out.println(buff);
		System.out.println(buff.length());
	}

}
