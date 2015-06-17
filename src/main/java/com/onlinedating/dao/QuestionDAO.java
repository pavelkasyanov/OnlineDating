package com.onlinedating.dao;


import com.onlinedating.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO implements IQuestionDAO {

    private List<Question> list;

    public QuestionDAO(){

        list = new ArrayList<Question>();
        list.add(new Question("Смотреть ужастики?"));
        list.add(new Question("Играть в шахматы?"));
        list.add(new Question("Поехать на выходные к маме?"));

    }

    @Override
    public void add(Question question) {
        list.add(question);
    }

    @Override
    public List<Question> getList() {
        return list;
    }
}
