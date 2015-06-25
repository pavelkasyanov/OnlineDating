package com.onlinedating.model.mvc;

import com.onlinedating.model.Question;

/**
 * Created by pavlik on 19.06.2015.
 */
public class AskRow {

    private Question question;
    private int countAnswered;
    private int countDenied;
    /*<c:out value="${askRow.countImportant}" />
    <c:out value="${askRow.countAgreed}"*/
    public AskRow(Question question) {
        this.question = question;
    }


    public Question getQuestion() {
        return question;
    }

    public int getCountAnswered() {
        return countAnswered;
    }

    public void setCountAnswered(int countAnswered) {
        this.countAnswered = countAnswered;
    }

    public int getCountDenied() {
        return countDenied;
    }

    public void setCountDenied(int countDenied) {
        this.countDenied = countDenied;
    }

}