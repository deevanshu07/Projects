package com.info.apple;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.info.model.Employee;
import com.info.repository.EmployeeRepository;
import com.info.service.EmployeeHandler;

@Controller
public class HomeController {

	@Autowired
	private EmployeeRepository employee;
	
	@Autowired
	EmployeeHandler empHandler;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);


		
		
		
		List employees = empHandler.findById("5a8842a4bc526e60350a694c");
		System.out.println("The employye is=" + employees);
		Gson gson = new Gson();
		System.out.println(gson.toJson(employees));
		ModelAndView modelandview = new ModelAndView("home");
		modelandview.addObject("employees", employees);
		return modelandview;
	}

}
