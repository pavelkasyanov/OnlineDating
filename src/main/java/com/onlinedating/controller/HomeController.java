package com.onlinedating.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpServletRequest request) {
		if (request.getSession().getAttribute("login_user") != null) {

			List<String> myAskList = new ArrayList<String>();
			myAskList.add("Ну что, похудела к лету, принцесска толстожопенькая?");
			myAskList.add("У вас тоже перед сном возникает вопрос: \"Какую же жизнь придумать сегодня.\"?");
			myAskList.add("Наливаю пол кружки горячей воды, завариваю чай и доливаю пол кружки холодной, я же не один такой?");
			myAskList.add("А вы тоже измеряете дорогу в песнях?");
			myAskList.add("А вы замечали, что если в автобусе или маршрутке много свободных мест, люди стараются сесть как можно дальше друг от друга?");
			myAskList.add("Кто-нибудь пробовал худеть лёжа на диване?");

			model.addAttribute("myAskList", myAskList);


			String aboutMeText = "С шести лет и до шестнадцати я занималась музыкой. И две мои сестры занимались музыкой. В коридоре\n" +
					"      висел специальный ремень для тех, кто отказывался заниматься музыкой. Говорили, у меня талант. Мой\n" +
					"      плейлист – это песни, которые берут в долгую дорогу, чтобы не заснуть. Там рядом Тэйлор Свифт и Михаил\n" +
					"      Шуфутинский. Я усердно учусь и моей профессией будет преподавание русского языка и литературы в старших классах.\n" +
					"      Парни думают, что быть учительницей – это моя сексуальная фантазия. Нет. Это призвание. А ещё мне нравится\n" +
					"      готовить пироги и торты. Только сама я их не ем. Чтобы другим больше было";
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