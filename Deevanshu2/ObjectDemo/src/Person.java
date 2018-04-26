import java.io.Serializable;


public class Person implements Serializable
{
	static final int serialVersionUID=100;
	int id;
	String name;
	String age;
	
	public Person(int id, String name, String age) 
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}


}
