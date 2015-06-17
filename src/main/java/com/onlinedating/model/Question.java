package com.onlinedating.model;

/**
 * Created by Aver on 17.06.2015.
 */
public class Question {
    private int QuestionID;
    private String text;
    private int Priority;
    private java.util.Date date;
    private Category category;
    private QuestionList questionList;
    private User owner;
    private int my_fav;


    public int getQuestionID()
    {
        return QuestionID;
    }
    public  void  setQuestionID(int id)
    {
        this.QuestionID = id;
    }
    public java.util.Date getDate()
    {
        return date;
    }
    public  void  setDate(java.util.Date date)
    {
        this.date = date;
    }

    public int getPriority()
    {
        return Priority;
    }
    public  void  setPriority(int priority)
    {
        this.Priority = priority;
    }

    public String getText()
    {
        return text;
    }
    public  void  setText(String text)
    {
        this.text = text;
    }
    public Category getCategory()
    {
        return category;
    }
    public  void  setCategory (Category category)
    {
        this.category = category;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getMy_fav() {
        return my_fav;
    }

    public void setMy_fav(int my_fav) {
        this.my_fav = my_fav;
    }

    public QuestionList getQuestionList() {
        return questionList;
    }

    public void setQuestionList(QuestionList questionList) {
        this.questionList = questionList;
    }
}
