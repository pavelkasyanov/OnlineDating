package com.onlinedating.controller;

import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.model.Question;
import com.onlinedating.model.QuestionList;
import com.onlinedating.model.User;
import com.onlinedating.model.mvc.AskRow;
import com.onlinedating.service.QuestionListService;
import com.onlinedating.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class HomeController {

	public static final String CUR_USER = "cur_user";
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
		if (request.getSession().getAttribute(CUR_USER) != null) {

			User user = (User)request.getSession().getAttribute(CUR_USER);
			//QuestionList questionList = questionListService.get_btID(user.getQuestionList().getQuestionListID());
			//Set<Question> list = questionList.getQuestions();
			Set<Question> questions = userService.getQuestions(user);

			//TODO add url user
			model.addAttribute("avatartUrl",user.getPhoto().getUrl());

			//TODO aboutme
			model.addAttribute("aboutMeText",user.getUser_Inf());

			addQuestions(model, questions);

			return "home";
		}

		return "redirect:/";
	}

	private void addQuestions(ModelMap model, Set<Question> questions) {
		model.addAttribute("myAskList", questions);

		List<AskRow> stat = getStat(questions);
		model.addAttribute("askRowList", stat);

//			<c:out value="${askRow.question.text}" />
//
//			<c:out value="${askRow.countAnswered}" />
//			<c:out value="${askRow.countDenied}" />
//			<c:out value="${askRow.countImportant}" />
//			<c:out value="${askRow.countAgreed}" />
//
	}

//	TODO to servis

	private List<AskRow> getStat(Set<Question> questions) {
		List<AskRow> askRows = new ArrayList<AskRow>();
		for (Question question:questions){
			AskRow askRow = new AskRow(question);
			askRow.setCountAnswered(15);
			askRow.setCountDenied(20);
			askRows.add(askRow);


		}
		return askRows;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("login") String login,
						@RequestParam("pass") String pass,
						HttpServletRequest request,
						HttpServletResponse response) throws IOException {

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper converter = new ObjectMapper();

		if (login != null || !login.equals("")) {

			User user = userService.get(login);
			System.out.println("User service get glogih");

			if (user != null) {
				request.getSession().setAttribute(CUR_USER, user);
				map.put("answer", "");
				return converter.writeValueAsString(map);
			}

			map.put("answer", "user not exist");
			return converter.writeValueAsString(map);
		}

		map.put("answer", "error");
		return converter.writeValueAsString(map);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model,
						 HttpServletRequest request) {

		request.getSession().removeAttribute(CUR_USER);

		return "redirect:home";
	}
}