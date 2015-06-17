package com.onlinedating.model;

import java.util.List;

import static com.onlinedating.model.CompatibilityAnswers.*;
import static com.onlinedating.model.CompatibilityMarks.*;
/**
 * Created by Кирилл on 17.06.15.
 */

public class CheckCompatibility {
    private int valueWoman = 0;
    private int valueMan = 0;
    private int persent = 0;
    public void check(int Priority,String value)
    {
        if(!value.equals("")) {
            if ((Priority == 1) && (value.equals(ANSWER_YES_EASY))) {
                valueWoman += INSPECTED_IMPORTANT_YES_EASY;
                valueMan += WHOCHECKS_IMPORTANT_YES_EASY;
            }
            if ((Priority == 1) && (value.equals(ANSWER_YES_HEAVILY))) {
                valueWoman += INSPECTED_IMPORTANT_YES_HEAVY;
                valueMan += WHOCHECKS_IMPORTANT_YES_HEAVY;
            }
            if ((Priority == 1) && (value.equals(ANSWER_NO))) {
                valueWoman += INSPECTED_IMPORTANT_NO;
                valueMan += WHOCHECKS_IMPORTANT_NO;
            }

            if ((Priority == 0) && (value.equals(ANSWER_YES_EASY))) {
                valueWoman += INSPECTED_NOTIMPORTANT_YES_EASY;
                valueMan += WHOCHECKS_NOTIMPORTANT_YES_EASY;
            }
            if ((Priority == 0) && (value.equals( ANSWER_YES_HEAVILY)))
            {
                valueWoman += INSPECTED_NOTIMPORTANT_YES_HEAVY;
                valueMan += WHOCHECKS_NOTIMPORTANT_YES_HEAVY;
            }
            if ((Priority == 0) && (value.equals(ANSWER_NO))) {
                valueWoman += INSPECTED_NOTIMPORTANT_NO;
                valueMan += WHOCHECKS_NOTIMPORTANT_NO;
            }
        }
        else
            persent -= 1;
    }

    public int[] chechSum(List<Integer> values)// get maximum Compatibility
    {
        int[] maxMark = new int[2];
        for(int q = 0;q<values.size();q++) {
            if(values.get(q) == 1)
            {
                maxMark [1] += WHOCHECKS_MAX_MARK_IMPORTANT;
                maxMark [0] += INSPECTED_MAX_MARK_IMPORTANT;
            }
            if (values.get(q) == 0)
            {
                maxMark [1] += WHOCHECKS_MAX_MARK_NOTIMPORTANT;
                maxMark [0] += INSPECTED_MAX_MARK_NOTIMPORTANT;
            }
        }
        return maxMark ;
    }
    public int getValueWoman()
    {
        return valueWoman;
    }
    public int getValueMan()
    {
        return valueMan;
    }
    public int getPersent()
    {
        return persent;
    }

}
