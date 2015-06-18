package com.onlinedating.controller;

import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.model.Question;
import com.onlinedating.model.QuestionList;
import com.onlinedating.model.User;
import com.onlinedating.service.QuestionListService;
import com.onlinedating.service.QuestionService;
import com.onlinedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

	@Autowired
	QuestionDAO questionService;
	@Autowired
	QuestionListService questionListService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpServletRequest request) {
		if (request.getSession().getAttribute("login_user") != null) {

			User user = userService.get((String)request.getSession().getAttribute("login_user"));
			QuestionList questionList = questionListService.get_btID(user.getQuestionList().getQuestionListID());
			Set<Question> list = questionList.getQuestions();
			model.addAttribute("myAskList",list );
			model.addAttribute("avatartUrl",user.getPhoto().getUrl());

			model.addAttribute("aboutMeText",user.getUser_Inf());


			/*String avatarUrl = "/resources/css/img/ph1.jpg";
			model.addAttribute("avatartUrl", avatarUrl);*/

			return "home";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("login") String login,
						@RequestParam("pass") String pass,
						HttpServletRequest request,
						HttpServletResponse response) {

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		if (login != null || !login.equals("")) {

			User user = userService.get(login);
			if (user != null) {
				request.getSession().setAttribute("login_user", login);
				return "";
			}

			return "user not exist!";
		}

		return "error";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model,
						 HttpServletRequest request) {

		request.getSession().removeAttribute("login_user");

		return "redirect:home";
	}
}