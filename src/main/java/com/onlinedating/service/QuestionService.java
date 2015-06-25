package com.onlinedating.service;

import com.onlinedating.model.Question;
import com.onlinedating.model.User;
import com.onlinedating.model.mvc.AskRow;

import java.util.List;
import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
public interface QuestionService {
    Question Add(String questionText, String login_user);

    Question get_btID(int id);

    void update(Question question, int id);

    void delete(int id);


    List<Question> getLast(int count);

    List<Question> question_list();

    void init();

    void addQuestions(Set<Question> questions);

    Set<AskRow> getAnswers(User user);

    void setUserService(UserService userService);
}
