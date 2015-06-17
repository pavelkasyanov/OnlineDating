package com.onlinedating.service;

import com.onlinedating.model.Question;

import java.util.List;

public interface IQuestionService {

    void add(String question);

    List<Question> getList();

}
