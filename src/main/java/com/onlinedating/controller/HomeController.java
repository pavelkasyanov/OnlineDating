package com.onlinedating.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpServletRequest request) {
		if (request.getSession().getAttribute("login_user") != null) {
			return "home";
		}

		return "redirect:/";
	}
}