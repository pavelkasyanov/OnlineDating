package com.onlinedating.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationController {

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
