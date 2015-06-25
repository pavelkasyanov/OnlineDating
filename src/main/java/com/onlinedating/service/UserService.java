package com.onlinedating.service;

import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import com.onlinedating.model.mvc.AskRow;

import java.util.List;
import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
public interface UserService {
    void init();

    User get(int id);
    User get(String login);
    void add(User user);
    void update( User user, int id);
    List<User> getList();

    Set<Question> getQuestions(User user);

    Set<AskRow> getAnswers(User user);

}
