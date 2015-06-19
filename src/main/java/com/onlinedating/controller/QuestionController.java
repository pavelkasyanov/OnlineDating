package com.onlinedating.controller;


import com.onlinedating.model.Question;
import com.onlinedating.model.mvc.QuestionModel;

import com.onlinedating.service.CategoryService;
import com.onlinedating.service.QuestionService;
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
import java.io.IOException;

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
        model.addAttribute("last_questions",questionService.getLast());
        model.addAttribute("myQuestionList", userService.get(userLogin).getQuestions());
        model.addAttribute("categoryList", categoryService.category_list());

        return "edit";
    }

    @RequestMapping(value = "/add_ask_ajax", method = RequestMethod.POST)
    @ResponseBody
    public String addAsk(@RequestParam(value = "questionText") String questionText,
                            @RequestParam(value = "category_new") String category,
                            HttpServletRequest request) throws IOException {

        Question question = null;
        QuestionModel questionModel = null;
        ObjectMapper converter = new ObjectMapper();
            if (true) {

                question = questionService.Add(questionText,
                        (String) request.getSession().getAttribute("login_user"),
                        category);

                questionModel = new QuestionModel();

                questionModel.setText(question.getText());
                questionModel.setDate(question.getDate());
                questionModel.setMy_fav(question.getMy_fav());
                questionModel.setPriority(question.getPriority());
            }

            return converter.writeValueAsString(questionModel);
    }
}