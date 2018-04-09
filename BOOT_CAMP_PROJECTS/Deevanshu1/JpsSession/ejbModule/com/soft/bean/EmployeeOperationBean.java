package com.soft.bean;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.soft.ejb.Employee;
@Stateless
public class EmployeeOperationBean implements EmployeeOperationBeanRemote, EmployeeOperationBeanLocal {

    @PersistenceContext(unitName="TrainingUnit")
    private EntityManager em;
    
    public EmployeeOperationBean() 
    {
        
    }

	@Override
	public int addEmployee(Employee emp) 
	{
		em.persist(emp);
		return emp.getEmpId();
	}

	@Override
	public Employee getEmployee(int empId) 
	{
		Employee emp1=(Employee) em.find(Employee.class,empId);
		
		return emp1;
	}

	public ArrayList getAllEmployee() 
	{
		ArrayList all= new ArrayList();
		String query="from Employee";
		Query que=em.createQuery(query);
		all=(ArrayList)que.getResultList();
		
		return all;
	}
	
	ArrayList remove;
	@Override
	public int removeEmployee(int empId)
	{
		remove = new ArrayList();
		
		Employee emp2=(Employee) em.find(Employee.class,empId);
		em.remove(emp2);
	
		return 1;
	}

	
	
/*	public ArrayList removeEmployee(int empId) 
	{
		
		Employee emp2=(Employee) em.find(Employee.class,empId);
		em.remove(emp2);
		String query="from Employee";
		Query que=em.createQuery(query);
		remove=(ArrayList)que.getResultList();
       
        int row=que.executeUpdate();
		return remove;
	}*/
	
	

}
