package com.info.model;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/home")
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	/*
	 * @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	 * public ModelAndView hello(@PathVariable ("name") String name){
	 * logger.debug("hello() is executed - $name {}", name); ModelAndView model=
	 * new ModelAndView(); model.setViewName("home");
	 * 
	 * model.addObject("title", helloWorldService.getTitle(name));
	 * model.addObject("msg", helloWorldService.getDesc()); return model;
	 * 
	 * }
	 */

	@RequestMapping("/hello/{name}/{country}")
	public ModelAndView successPage(@PathVariable("name") String name,
			@PathVariable("country") String country) {

		ModelAndView model = new ModelAndView("home");

		return model;

	}

	@RequestMapping(value = "/addmission.html", method = RequestMethod.GET)
	public ModelAndView getAddmission() {
		ModelAndView model = new ModelAndView("addmission");
		return model;
	}

	
	@RequestMapping(value = "submitForm.html", method = RequestMethod.POST)
	public ModelAndView submitForm(
			@ModelAttribute("employee1") Employee employee, BindingResult result) {
		if(!employee.getEmployeeId().isEmpty()){
			throw new RuntimeException();
		}
		if(result.hasErrors()){
			ModelAndView model= new ModelAndView("addmission");
			return model;
		}
		ModelAndView model = new ModelAndView("success");
		return model;
	}

	@ModelAttribute
	public void addHeadderinJsp(Model model){
		model.addAttribute("headermessage", "Admission Form");
	}
	
	@ExceptionHandler(value=RuntimeException.class)
	public String runTimeException(){
		return "exception";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String Exception(){
		return "exception";
	}
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	}
}
