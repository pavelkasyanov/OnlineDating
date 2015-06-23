package com.onlinedating.model;

import java.util.Set;




import java.util.Set;

public class User implements java.io.Serializable {
    private int UserID;
    private String User_login;
    private String User_Name;
    private String User_Inf;
    private String Sex;
    private City city;
    private QuestionList questionList;
    private Set<Question> questions;
    private Photo photo;
    private Set<Answer> answers;

    public int getUserID() {
        return UserID;
    }
    public void setUserID(int id) {
        this.UserID = id;
    }
    public String getUser_Name() {
        return User_Name;
    }
    public void setUser_Name(String name) {
        this.User_Name = name;
    }

    public String getUser_login() {
        return User_login;
    }
    public void setUser_login(String login) {
        this.User_login = login;
    }
    public String getUser_Inf() {
        return User_Inf;
    }
    public void setUser_Inf(String inf) {
        this.User_Inf = inf;
    }



    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public QuestionList getQuestionList() {
        return questionList;
    }
    public void setQuestionList(QuestionList questionList) {
        this.questionList = questionList;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}