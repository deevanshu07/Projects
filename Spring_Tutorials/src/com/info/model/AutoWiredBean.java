package com.info.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppCongifs {
	@Bean
	public Employee getEmployee() {
		return new Employee();

	}

	@Bean
	public Company getCompany() {
		Company company = new Company();
		company.setCompName("ABCD Ltd");
		company.setLocation("Varanasi");
		return company;
	}
}

public class AutoWiredBean {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppCongifs.class);
		ctx.refresh();
		Employee employee = ctx.getBean(Employee.class);
		System.out.println("Company Name:"
				+ employee.getCompany().getCompName());
		System.out.println("Location:" + employee.getCompany().getLocation());
		ctx.close();

	}
}

class Employee {
	

	private Company company;

	@Autowired
	public Employee(Company company){
		this.company=company;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Company getCompany() {
		return company;
	}

	void setCompany(Company company) {
		this.company = company;
	}
}

class Company {
	private String compName;
	private String location;

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
