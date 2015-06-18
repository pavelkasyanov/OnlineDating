package com.onlinedating.controller;


import com.onlinedating.dao.CategoryDAO;
import com.onlinedating.service.CategoryService;
import com.onlinedating.service.QuestionService;
import com.onlinedating.service.QuestionServiceImpl;
import com.onlinedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/ask", method = RequestMethod.GET)
    public String index(ModelMap model,
                        HttpServletRequest request) {

        String userLogin = (String) request.getSession().getAttribute("login_user");

        model.addAttribute("questionList", null);
        model.addAttribute("myQuestionList", userService.get(userLogin).getQuestions());
        model.addAttribute("categoryList", categoryService.category_list());

        return "edit";
    }

    @RequestMapping(value = "/add_ask", method = RequestMethod.POST)
    public String addAsk(@RequestParam(value = "questionText") String questionText, HttpServletRequest request) {


            if (questionText != null && !questionText.equals("")) {

                questionService.Add(questionText, (String)request.getSession().getAttribute("login_user"));
            }

            return "redirect:/ask";
    }
}