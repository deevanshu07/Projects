package com.info.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/rest")
public class RestController {
	
	@RequestMapping(value="/student",method=RequestMethod.GET,produces="application/xml")
	public @ResponseBody Student getList(){
		Student student= new Student("DEEVANSHU", 101);
		System.out.println("STUDENT");
		return student;
	}
	
	
	@RequestMapping(value="/json",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Student getJson(){
		Student student= new Student("DEEVANSHU", 101);
		System.out.println("JSON");
		return student;
	}

	@RequestMapping(value="/put",method=RequestMethod.PUT,consumes="application/json")
	public @ResponseBody List<Student> getJson1(@RequestBody Student stu){
		Student student= new Student("DEEVANSHU", 101);
		student.setId(stu.getId());
		student.setName(stu.getName());
		List<Student> s= new ArrayList<Student>();
		s.add(student);
		System.out.println("JSON");
		return s;
	}
	
}
