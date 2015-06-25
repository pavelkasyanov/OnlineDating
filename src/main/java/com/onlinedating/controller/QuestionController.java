package com.onlinedating.controller;


import com.onlinedating.model.Question;
import com.onlinedating.model.User;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "ask")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model,
                        HttpServletRequest request) {

        User user = (User)request.getSession().getAttribute(HomeController.CUR_USER);

        model.addAttribute("questionList", null);
        model.addAttribute("last_questions",questionService.getLast(10));
        model.addAttribute("myQuestionList", userService.getQuestions(user));
        model.addAttribute("categoryList", categoryService.category_list());

        return "edit";
    }

    @RequestMapping(value = "add_ask", method = RequestMethod.POST)
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

                questionModel = new QuestionModel(question);
            }

            return converter.writeValueAsString(questionModel);
    }

    @RequestMapping(value = "delete_ask", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAsk(@RequestParam(value = "askId") String askId)
            throws IOException {

        int askID = Integer.parseInt(askId);

        questionService.delete(askID);

        return "done";
    }

    @RequestMapping(value = "last_ask", method = RequestMethod.GET)
    @ResponseBody
    public String getLastQuestions()
            throws IOException {

        ObjectMapper converter = new ObjectMapper();

        List<Question> temp = questionService.getLast(10);
        List<QuestionModel> res = new ArrayList<QuestionModel>();

        for(Question q: temp) {
           res.add(new QuestionModel(q));
        }

        return converter.writeValueAsString(res);
    }
}