package com.onlinedating.service;

import com.onlinedating.dao.QuestionListDAO;
import com.onlinedating.model.QuestionList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aver on 17.06.2015.
 */
public class QuestionListServiceImpl implements QuestionListService {

    @Autowired
    QuestionListDAO questionListDAO;

    @Override
    public void Add(QuestionList questionList) {

        questionListDAO.Add(questionList);
    }

    @Override
    public QuestionList get_btID(int id) {

        return questionListDAO.get_btID(id);
    }
}
