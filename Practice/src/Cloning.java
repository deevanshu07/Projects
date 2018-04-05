import java.util.HashMap;

class AA implements Cloneable {
	int i;

	AA(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "AA [i=" + i + "]";
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

class BB implements Cloneable {
	int j;
	AA a;

	public BB(int j, AA a) {
		this.j = j;
		this.a = a;
	}

	public Object clone() throws CloneNotSupportedException {
		BB b = (BB) super.clone();
		b.a = (AA) a.clone();
		return b;
	}

	@Override
	public String toString() {
		return "BB [j=" + j + ", a=" + a + "]";
	}
}

class Emp{
	static{
		System.out.println("Deevanshu");
	}
}


class Stu{
	private int id;
	@Override
	public String toString() {
		return "Stu [id=" + id + "]";
	}

	public Stu(int id){
		this.id=id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stu other = (Stu) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

public class Cloning {
	public static void main(String[] args) throws Exception {


		HashMap<Stu, String> hashMap= new HashMap<Stu, String>();
		hashMap.put(new Stu(101352), "Nidhi");
		hashMap.put(new Stu(101349), "Deevanshu");
		hashMap.put(new Stu(101350), "ABCD");
		hashMap.put(new Stu(101356), "Kanica");
		hashMap.put(new Stu(101357), "Nihi");
		hashMap.put(new Stu(101358877), "isdfsddhi");
		hashMap.put(new Stu(101357777), "idsdfhi");
		hashMap.put(new Stu(101356677), "isdfsddhi");
		hashMap.put(new Stu(101322577), "idsdhi");
		hashMap.put(new Stu(1013534377), "idsdhi");		
		hashMap.put(new Stu(101353677), "idhsssi");
		hashMap.put(new Stu(1013577343), "idhsssaai");
		hashMap.put(new Stu(10135707), "idasashi");
		hashMap.put(new Stu(101997437), "idhiddfsf");
		hashMap.put(new Stu(101350077), "idhfdfdfdfdai");
		hashMap.put(new Stu(10135377), "iasdasdasddhi");
		hashMap.put(new Stu(10135777), "iddsvgdsfhi");
		hashMap.put(new Stu(101333577), "iddfgsdfehi");
		
		
		System.out.println(hashMap.size());

		
		
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", "Admin123");

		Statement stmt= con.createStatement();
		ResultSet rs= stmt.executeQuery("select * from info_employee");
		ResultSetMetaData meta= rs.getMetaData();
		con.close();
*/		
	}
}
