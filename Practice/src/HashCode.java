import java.util.HashMap;
import java.util.Objects;

class Employee {
	private int id;
	@Override
	public int hashCode() {
		System.out.println(Objects.hash(id,name));
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String name;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}

public class HashCode {
	public static void main(String[] args) {
		HashMap<Employee, Integer> hashMap = new HashMap<Employee, Integer>();
		hashMap.put(new Employee("Deevanshu", 101), 1);
		hashMap.put(new Employee("Mahajan", 102), 2);
		System.out.println(hashMap.get(new Employee("Deevanshu", 101)));
		System.out.println(hashMap.get(new Employee("Mahajan", 102)));
	}
}
