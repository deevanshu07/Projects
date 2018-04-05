package coding;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Objects;

class ABC {
	private int id;
	@Override
	public String toString() {
		return "ABC [id=" + id + ", name=" + name + "]";
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

	private String name;

	ABC(int id, String name){
		this.id=id;
		this.name=name;
	}
	/*@Override
	public int hashCode() {
		return 1;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ABC other = (ABC) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}


public class SortALinkedList {
	public static void main(String[] args) {
		HashMap<String, Integer> hashMap= new HashMap<String, Integer>();
		hashMap.put(new String("ABC") , 101);
		hashMap.put(new StringBuilder("ABC").toString() , 103);
		System.out.println(hashMap);
	}
}
