package com.onlinedating.service;

import com.onlinedating.model.*;
import com.onlinedating.model.Category;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface QuestionService
{
    Question Add( String question, User text, String category);

    Question get_btID(int id);
    void update( Question question, int id);
    void delete (int id);
    List<Question> getLast(int count);
    List<Question> getLastCategory(int count,List category);
    List<Question> getByCategory(String category);


    List<Question> question_list();
}
