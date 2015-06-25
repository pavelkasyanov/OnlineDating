package com.onlinedating.model;

import com.onlinedating.service.CompatibilityAnswers;

public class Answer {

    private Question question;
    private String answer;
    private int importance = -1;

    public Answer(Question question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Answer(Question question, int importance) {
        this.question = question;
        this.importance = importance;
    }

    public String getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }

    public int getImportance() {
        return importance;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question=" + question.getText() +
                ", answer='" + answer + '\'' +
                ", importance=" + importance +
                '}';
    }

    public String getImportanceText() {
        if (importance == CompatibilityAnswers.PRIORITY_IMPORTANT) {
            return "Мне это важно";
        }
        if (importance == CompatibilityAnswers.PRIORITY_UNIMPORTANT) {
            return "Мне это пофиг";
        }
        return "Не определено";
    }

    public void mergeAnswers(Answer answer) {
        if (this.importance == -1) {
            this.importance = answer.importance;
        }
        if (this.answer == null) {
            this.answer = answer.answer;
        }
    }
}
