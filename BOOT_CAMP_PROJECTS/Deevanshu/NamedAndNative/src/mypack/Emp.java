package mypack;

public class Emp {
int id;

String name,job;

public String toString() {
	return "Emp [id=" + id + ", name=" + name + ", job=" + job + "]";
}

public Emp(String name, String job) {
	super();
	this.name = name;
	this.job = job;
}

public Emp() {
	// TODO Auto-generated constructor stub
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
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}




}
