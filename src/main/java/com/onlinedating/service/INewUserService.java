package com.onlinedating.service;

import com.onlinedating.model.Question;
import com.onlinedating.model.User;

/**
 * Created by Artem.Zolotov on 6/23/2015.
 */
public interface INewUserService {
    void registerUser(User user);

    User getUser(User userQuestioner);

    void userValue(User userQuestioner, Question q, int important);

    void userAnswer(User userReporter, Question q, String answer);
}
