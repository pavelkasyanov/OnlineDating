package com.onlinedating.service;

import com.onlinedating.model.QuestionList;

/**
 * Created by Aver on 17.06.2015.
 */
public interface QuestionListService {

    void Add(QuestionList questionList);
   QuestionList get_btID(int id);
}
