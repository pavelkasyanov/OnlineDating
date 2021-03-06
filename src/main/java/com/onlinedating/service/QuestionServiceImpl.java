package com.onlinedating.service;

import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import com.onlinedating.model.mvc.AskRow;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
public class QuestionServiceImpl implements  QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    @Autowired
    UserService userService;
//    @Autowired
//    CategoryService categoryService;
//    @Autowired
//    QuestionListService questionListService;

    @Override
    public Question Add(String text, String user_login)
    {
        Question question = new Question();
        User user = userService.get(user_login);
        question.setText(text);
        question.setOwner(user);
        question.setPriority(0);
//        question.setCategory(categoryService.get_byName(category));
        question.setQuestionList(user.getQuestionList());
        Date dateoperation = new java.sql.Date(new java.util.Date().getTime());
        question.setDate(dateoperation);

        questionDAO.Add(question);

        return question;
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
    public List<Question> getLast(int count) {

        List<Question> last_list = question_list();
        Collections.sort(last_list, new QuestionDataComparator());
        int length = last_list.size();

        return (length < count ? last_list : last_list.subList(0, count));
    }

    @Override
    public List<Question> question_list() {
        return questionDAO.question_list();
    }

    @Override
    public void init() {

    }

    @Override
    public void addQuestions(Set<Question> questions) {

    }

    @Override
    public Set<AskRow> getAnswers(User user) {
        return null;
    }

    @Override
    public void setUserService(UserService userService) {

    }
}
