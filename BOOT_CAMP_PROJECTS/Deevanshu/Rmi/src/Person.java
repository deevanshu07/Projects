import java.io.Serializable;


public class Person implements Serializable {

	String name;
	String age;
	String location;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String age, String location) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
