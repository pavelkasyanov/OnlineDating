package com.onlinedating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {
    @RequestMapping(value = "/ask", method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "ask";
    }
}