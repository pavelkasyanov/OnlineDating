package com.onlinedating.service;

import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.dao.UserDAO;
import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */

public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    QuestionDAO questionDAO;

    @Override
    public User get(int id) {

        return userDAO.get_btID(id);
    }

    @Override
    public User get(String login) {

        return userDAO.get_byLogin(login);
    }

    @Override
    public void add(User user) {

        userDAO.Add(user);

    }

    @Override
    public void update(User user, int id) {

        userDAO.update(user,id);
    }

    @Override
    public List<User> getList() {
        return userDAO.list();
    }

    @Override
    public List<Question> getQuestions(User user) {
        return questionDAO.getQuestionFromUser(user.getUserID());
    }
}
