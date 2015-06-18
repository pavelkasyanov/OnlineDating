package com.onlinedating.service;

import com.onlinedating.dao.QuestionDAO;
import com.onlinedating.model.Category;
import com.onlinedating.model.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public class QuestionServiceImpl implements  QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    @Override
    public void Add(Question question) {
        questionDAO.Add(question);
    }

    @Override
    public Question get_btID(int id) {
        return questionDAO.get_btID(id);
    }

    @Override
    public void update(Question question, int id) {
        questionDAO.update(question, id);
    }

    @Override
    public void delete(int id) {
        questionDAO.delete(id);
    }

    @Override
    public List<Category> question_list() {
        return questionDAO.question_list();
    }
}
