package com.onlinedating.controller;


import com.onlinedating.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    /*@Autowired
    QuestionService questionService;*/
    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping(value = "/ask", method = RequestMethod.GET)
    public String index(ModelMap model) {

        model.addAttribute("questionList", null);
        model.addAttribute("categoryList", categoryDAO.category_list());

        return "edit";
    }

    @RequestMapping(value = "/add_ask", method = RequestMethod.POST)
    public String addAsk(@RequestParam(value = "questionText") String questionText) {

        if (questionText != null && !questionText.equals("")) {
            //questionService.add(questionText);
        }

        return "redirect:/ask";
    }
}