package com.onlinedating.model;

import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
public class QuestionList {
    private int QuestionListID;
    private Set<Question> questions;


    public int getQuestionListID()
    {
        return QuestionListID;
    }
    public  void  setQuestionListID(int id)
    {
        this.QuestionListID = id;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}

