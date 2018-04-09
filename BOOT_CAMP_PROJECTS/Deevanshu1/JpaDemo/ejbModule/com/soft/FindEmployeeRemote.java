package com.soft;

import javax.ejb.Remote;

@Remote
public interface FindEmployeeRemote 
{
	public String findEmployeee(int empId);

}
