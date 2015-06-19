package com.onlinedating.dao;

import com.onlinedating.model.Category;
import com.onlinedating.model.Question;
import com.onlinedating.model.QuestionList;

import java.util.List;

/**
 * Created by Aver on 17.06.2015.
 */
public interface QuestionDAO {

    void Add( Question question);

    Question get_btID(int id);
    void update( Question question, int id);
    void delete (int id);
    List<Category> question_list();
     List<Question> Get_Question_list_byquestionList(QuestionList questionList);
}
