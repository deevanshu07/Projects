package com.info.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.info.model.Employee;
import com.info.model.JsonMap;
import com.info.service.HibernateService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	HibernateService hibernateSerice;

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
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView authenticateUser(HttpSession session,
			@ModelAttribute("employee1") Employee employee1, BindingResult bindingResult) {

		ModelAndView model = new ModelAndView();

		if (bindingResult.hasErrors()) {
			model.setViewName("login");
			return model;

		}
		Employee emp = hibernateSerice.authenticateUser(employee1.getUserId());
		if (emp != null) {
			session.setAttribute("employee", emp);
			model.setViewName("index");
			return model;
		}

		model.addObject("message", "Login failed. Try Again!");
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/all/{type}", "/all" }, method = RequestMethod.GET)
	public ModelAndView pagination(
			@PathVariable Map<String, String> pathVariablesMap,
			HttpServletRequest req) {
		ModelAndView model = new ModelAndView("pagination");

		System.out.println("Pagination called");
		PagedListHolder<JsonMap> pagedList = null;
		String type = pathVariablesMap.get("type");
		if (null == type) {
			List<JsonMap> jsonList = hibernateSerice.getJsonData();
			pagedList = new PagedListHolder<JsonMap>();
			pagedList.setSource(jsonList);
			pagedList.setPageSize(10);
			req.getSession().setAttribute("pagedList", pagedList);
		} else if ("next".equals(type)) {

			pagedList = (PagedListHolder<JsonMap>) req.getSession()
					.getAttribute("pagedList");
			pagedList.nextPage();
			printPageDetails(pagedList);

		}

		else if ("prev".equals(type)) {
			pagedList = (PagedListHolder<JsonMap>) req.getSession()
					.getAttribute("pagedList");
			pagedList.previousPage();
			printPageDetails(pagedList);
		} else {
			System.out.println("type: " + type);
			pagedList = (PagedListHolder<JsonMap>) req.getSession()
					.getAttribute("pagedList");
			int pageNum = Integer.parseInt(type);
			pagedList.setPage(pageNum);
			printPageDetails(pagedList);
		}

		System.out.println(pagedList.getPageList());
		return model;
	}

	private void printPageDetails(PagedListHolder productList) {

		System.out.println("curent page - productList.getPage() :"
				+ productList.getPage());

		System.out.println("Total Num of pages - productList.getPageCount :"
				+ productList.getPageCount());

		System.out.println("is First page - productList.isFirstPage :"
				+ productList.isFirstPage());

		System.out.println("is Last page - productList.isLastPage :"
				+ productList.isLastPage());
	}

}
