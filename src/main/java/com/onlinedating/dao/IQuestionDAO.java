package com.onlinedating.dao;

import com.onlinedating.model.Question;

import java.util.List;

public interface IQuestionDAO {

    void add(Question question);

    List<Question> getList();

}
