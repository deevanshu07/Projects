package coding;
public class AnagramStrings {
	public static void main(String[] args) {

		String str = "maha";
		String str1 = "hama";
		int i = 0, j = 0;
		String s = "";
		System.out.println("MM");
		char ch[] = str.toCharArray();
		while (i < str.length()) {
			i++;
			while (j < str.length()) {
				if (str.charAt(i) >= str.charAt(j)) {
					char m = ch[i];
					ch[i] = ch[j];
					ch[j] = m;

				}
			}
			s = s + ch[i];
		}
		System.out.println(s);
	
	}
}
