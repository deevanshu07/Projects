import java.io.Serializable;

public class Employee implements Serializable
{
	String designation;
	int id;
	String name;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int id, String designation) {
		super();
		this.name = name;
		this.id = id;
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
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

	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public void setName(String name) {
		this.name = name;
	}

}
