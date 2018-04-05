package com.info.model;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;


@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public ModelAndView helloFunction(){
		String message="Spring Tutorials";
		return new ModelAndView("hellopage","message",message);
	}
	

}
