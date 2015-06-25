package com.onlinedating.controller;


import com.onlinedating.model.User;
import com.onlinedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "search")
public class SearchController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
        List<User> userList = userService.getList();
        model.addAttribute("userList", userList);


        return "search";
    }


}
