package com.onlinedating.service;

import com.onlinedating.model.Question;

import java.util.Comparator;

/**
 * Created by Aver on 19.06.2015.
 */
public class QuestionDataComparator implements Comparator<Question> {


    @Override
    public int compare(Question o1, Question o2) {
        return o2.getDate().compareTo(o1.getDate());
    }

}
