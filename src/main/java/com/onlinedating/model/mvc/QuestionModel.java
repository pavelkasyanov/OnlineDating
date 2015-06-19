package com.onlinedating.model.mvc;

import com.onlinedating.model.Category;
import com.onlinedating.model.Question;
import com.onlinedating.model.QuestionList;
import com.onlinedating.model.User;

/**
 * Created by pavlik on 19.06.2015.
 */
public class QuestionModel {

    private int QuestionID;
    private String text;
    private int Priority;
    private java.util.Date date;
    private int my_fav;

    public QuestionModel(){

    }

    public QuestionModel(Question question) {
        this.QuestionID = question.getQuestionID();
        this.text = question.getText();
        this.date = question.getDate();
        this.my_fav = question.getMy_fav();
        this.Priority = question.getPriority();
    }

    public int getQuestionID() {
        return QuestionID;
    }
    public void setQuestionID(int questionID) {
        QuestionID = questionID;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public int getMy_fav() {
        return my_fav;
    }

    public void setMy_fav(int my_fav) {
        this.my_fav = my_fav;
    }
}
