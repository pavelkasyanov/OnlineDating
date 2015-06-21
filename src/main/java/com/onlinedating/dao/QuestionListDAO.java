package com.onlinedating.dao;

import com.onlinedating.model.QuestionList;
import com.onlinedating.model.User;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface QuestionListDAO {
    void Add( QuestionList questionList);
    QuestionList get_btID(int id);
}

