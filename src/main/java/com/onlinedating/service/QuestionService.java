package com.onlinedating.service;


import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.model.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionService  implements IQuestionService {

    @Autowired
    QuestionDAO questionDAO;

    @Override
    public void add(String question) {
        Question q = new Question(question);
        questionDAO.add(q);
    }

    @Override
    public List<Question> getList() {
        return questionDAO.getList();
    }
}
