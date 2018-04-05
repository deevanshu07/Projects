package com.info.apple;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/rest")
public class RestController {


	Employee emp= new Employee();
	@RequestMapping(value="/json/{name}",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Employee getEmployee(@PathVariable String name){
		emp.setName(name);
		emp.setId(101);
		return emp;
	}

}
