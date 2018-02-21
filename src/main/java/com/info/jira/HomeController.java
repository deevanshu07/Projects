package com.info.jira;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.info.jira.service.IssueServiceHandler;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	IssueServiceHandler issueHandler;

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

	@RequestMapping(value = "/createIssue/{num1}/{num2}", method = RequestMethod.GET)
	public ModelAndView createIssue(@PathVariable(value = "num1") int num1,
			@PathVariable(value = "num2") int num2) throws URISyntaxException {

		ModelAndView model = new ModelAndView();
		String statusResponse = "";
		int result = 0;
		try {
			result = num1 / num2;
			System.out.println(result);
		}

		catch (Exception e) {
		System.out.println(e.getMessage());
		statusResponse=issueHandler.createIssue();
		}

		if (!statusResponse.equals("")) {
			model.addObject("status", statusResponse);
			model.setViewName("error");
		}

		else {
			model.setViewName("result");
			model.addObject("result", result);
		}

		return model;

	}

}
