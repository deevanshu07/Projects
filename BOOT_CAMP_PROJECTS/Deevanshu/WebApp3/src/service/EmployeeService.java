package service;
import model.*;
import java .sql.*;
import java.util.*;
public class EmployeeService {

	
	
	public List<Employee> showEmployees(){
		
		
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee(1,"Deevanshu"));
		empList.add(new Employee(1,"Mahajan"));
	
		return empList;
	}
}
