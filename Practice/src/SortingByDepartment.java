import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Employees {
	private int id;
	private String name;
	private String department;

	public Employees(int id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", department="
				+ department + "]";
	}
}

public class SortingByDepartment {
	public static void main(String[] args) {

		List<Employees> list = new ArrayList<Employees>();
		list.add(new Employees(101, "Deevanshu", "IT"));
		list.add(new Employees(102, "DeV", "HR"));
		list.add(new Employees(103, "Mahajan", "IT"));
		list.add(new Employees(104, "Kanica", "HR"));
		list.add(new Employees(105, "ABCD", "ADMIN"));

		Map<String, Integer> count = new HashMap<String, Integer>();
		Iterator<Employees> ite = list.iterator();
		while (ite.hasNext()) {
			String key = ite.next().getDepartment();
			if (count.containsKey(key)) {
				int rr = Integer.valueOf(count.get(key));
				rr++;
				count.put(key, rr);
			} else {
				count.put(key, 1);
			}
		}
		System.out.println(count);
		
	}

}
