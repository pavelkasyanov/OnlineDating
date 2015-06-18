package com.onlinedating.service;

import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.model.Category;
import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class QuestionServiceImpl implements  QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    QuestionListService questionListService;
    @Override
    public void Add(String text,String user_login)
    {
        Question question = new Question();
        User user = userService.get(user_login);
        question.setText(text);
        question.setOwner(user);
        question.setPriority(0);
        question.setCategory(categoryService.get_btID(1));
        question.setQuestionList(user.getQuestionList());
        Calendar cal = Calendar.getInstance();
        question.setDate(cal.getTime());
        questionDAO.Add(question);
    }

    @Override
    public Question get_btID(int id) {
        return questionDAO.get_btID(id);
    }

    @Override
    public void update(Question question, int id) {
        questionDAO.update(question, id);
    }

    @Override
    public void delete(int id) {
        questionDAO.delete(id);
    }

    @Override
    public List<Category> question_list() {
        return questionDAO.question_list();
    }
}
