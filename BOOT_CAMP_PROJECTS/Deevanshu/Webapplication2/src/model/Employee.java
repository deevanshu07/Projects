package model;

public class Employee {
	private int empAge;
	private String empName;
	@Override
	public String toString() {
		return "Employee [empAge=" + empAge + ", empName=" + empName
				+ ", empSalary=" + empSalary + ", deptName=" + deptName + "]";
	}

	private double empSalary;
	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Employee(String empName, int empAge, double empSalary,String depName) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.deptName=depName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public String getEmpName() {
		return empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	
}
