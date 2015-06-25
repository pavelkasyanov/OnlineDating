package com.onlinedating.controller;

import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.service.CheckCompatibility;
import com.onlinedating.model.Question;
import com.onlinedating.model.User;
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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.onlinedating.service.CompatibilityAnswers.ANSWER_YES_EASY;
import static com.onlinedating.service.CompatibilityAnswers.PRIORITY_IMPORTANT;
import static com.onlinedating.service.CompatibilityAnswers.PRIORITY_UNIMPORTANT;

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
			///QuestionList questionList = questionListService.get_btID(user.getQuestionList().getQuestionListID());
			//Set<Question> list = questionList.getQuestions();
			Set<Question> questions = userService.getQuestions(user);
			model.addAttribute("myAskList", questions);

			//TODO add url user
			//model.addAttribute("avatartUrl",user.getPhoto().getUrl());

			//TODO aboutme
			//model.addAttribute("aboutMeText",user.getUser_Inf());

			testCheckCompatibility(request);
			return "home";
		}

		return "redirect:/";
	}

	private void testCheckCompatibility(HttpServletRequest request) {
		//TODO load properties
		CheckCompatibility cC;
		ServletContext context = request.getSession().getServletContext();
		InputStream iS = context.getResourceAsStream("/WEB-INF/classes/configCompatibility.properties");
		cC = new CheckCompatibility(iS);
		cC.check(PRIORITY_UNIMPORTANT,ANSWER_YES_EASY);
		int valueInspected = cC.getValueQuestioner();
		System.out.println(valueInspected);
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

		if (login != null || !"".equals(login)) {

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