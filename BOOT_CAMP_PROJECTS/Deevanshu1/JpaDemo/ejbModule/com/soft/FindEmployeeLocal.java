package com.soft;

import javax.ejb.Local;

@Local
public interface FindEmployeeLocal 
{
	public String findEmployeee(int empId);

}
