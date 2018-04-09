package com.soft;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.Employee;

@Stateless
public class FindEmployee implements FindEmployeeRemote, FindEmployeeLocal {

   @PersistenceContext(unitName="TrainingUnit")
   private EntityManager em;
    public FindEmployee() 
    {
      
    }

	@Override
	public String findEmployeee(int empId)
	{
		Employee emp=(Employee)em.find(Employee.class, empId);
		
		return emp.getEmpName();
	}

}
