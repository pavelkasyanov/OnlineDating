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

import javax.servlet.http.HttpServletRequest;
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
			List<Question> list = questionService.Get_Question_list_byquestionList(questionList);
			//Set<Question> list = user.getQuestions();
			model.addAttribute("myAskList",list );
			String aboutMeText = user.getUser_Inf();
			model.addAttribute("aboutMeText", aboutMeText);

			String avatarUrl = "/resources/css/img/ph1.jpg";

			model.addAttribute("avatartUrl", avatarUrl);

			return "home";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model,
						@RequestParam("login") String login,
						@RequestParam("password") String pass,
						HttpServletRequest request) {

		if (login != null || !login.equals("")) {
			request.getSession().setAttribute("login_user", login);
		}

		return "redirect:home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model,
						 HttpServletRequest request) {

		request.getSession().removeAttribute("login_user");

		return "redirect:home";
	}
}