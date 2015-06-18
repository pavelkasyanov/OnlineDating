package com.onlinedating.dao;

import com.onlinedating.model.Category;
import com.onlinedating.model.Question;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface QuestionDAO {
    void Add( Question question);

    Question get_btID(int id);
    void update( Question question, int id);

    List<Category> question_list();
}
