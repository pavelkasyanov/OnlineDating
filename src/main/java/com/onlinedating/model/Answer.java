package com.onlinedating.model;

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
}
