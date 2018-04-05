package com.info.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Employee;
import com.info.service.HibernateService;

/**
 * Handles requests for the application home page.
 */
@ControllerAdvice
@Controller
public class HomeController {

	
	@Autowired
	HibernateService hiberSerive;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
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
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView authenticateUser(@RequestParam int userId, @RequestParam String password){
		ModelAndView model= new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value={"/getData","/putData","/postData","/deleteData"}, method=RequestMethod.GET)
	public ModelAndView getForm(){
		ModelAndView model= new ModelAndView("index");
		return model;
	}

}
