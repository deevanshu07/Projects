import java.io.Serializable;
import java.util.Date;


public class Employees implements Serializable {


	
	


	public Employees(int employeeId, String firstName, String lastName,
			String email, String phoneNumber, Date hireDate, String jobId,
			int salary, int commissionPact, int managerId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		LastName = lastName;
		Email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPact = commissionPact;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}
	int employeeId;
	String firstName;
	String LastName;
	String Email;
	String phoneNumber;
	Date hireDate= new Date();
	String jobId;
	int salary;
	int commissionPact;
	int managerId;
	int departmentId;



	@Override
	public String toString()
	{
		return "Departments [employeeId=" + employeeId + ", firstName="
				+ firstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
				+ ", jobId=" + jobId + ", salary=" + salary
				+ ", commissionPact=" + commissionPact + ", managerId="
				+ managerId + ", departmentId=" + departmentId + "]";
	}
	



public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Date getHireDate() {
	return hireDate;
}
public void setHireDate(Date hireDate) {
	this.hireDate = hireDate;
}
public String getJobId() {
	return jobId;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public int getCommissionPact() {
	return commissionPact;
}
public void setCommissionPact(int commissionPact) {
	this.commissionPact = commissionPact;
}
public int getManagerId() {
	return managerId;
}
public void setManagerId(int managerId) {
	this.managerId = managerId;
}
public int getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}

}
