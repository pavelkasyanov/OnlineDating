package com.onlinedating.model.mvc;

import com.onlinedating.model.Answer;
import com.onlinedating.model.Question;

/**
 * Created by pavlik on 19.06.2015.
 */
public class AskRow {
   private Question question;
   private int countAnswered;
   private int countDenied;
    private Answer answer;
    private int countValued;

    //  	<c:out value="${askRow.countImportant}" />
////			<c:out value="${askRow.countAgreed}"
    public AskRow(Question question) {


        this.question = question;
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

    public Question getQuestion() {
        return question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setCountValued(int countValued) {
        this.countValued = countValued;
    }

    public int getCountValued() {
        return countValued;
    }
}
