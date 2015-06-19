package com.onlinedating.model;

import java.util.List;

import static com.onlinedating.model.CompatibilityAnswers.*;
import static com.onlinedating.model.CompatibilityMarks.*;
/**
 * Created by Кирилл on 17.06.15.
 */

public class CheckCompatibility {
    private int valueInspected = 0;
    private int valueWhoChecks = 0;
    private int percent = 0;

    static final int PRIORITY_IMPORTANT = 1;
    static final int PRIORITY_NOTIMPORTANT = 0;
    public void check(int priority,String value)
    {
        CompatibilityMarks comMarks = new CompatibilityMarks();
        if(value == null) {
            if (PRIORITY_IMPORTANT == priority)
            {
                if(ANSWER_YES_EASY.equals(value)) {
                    valueInspected += comMarks.getInspectedImportantYesEasy();
                    valueWhoChecks += comMarks.getWhochecksImportantYesEasy();
                }
                if (ANSWER_YES_HEAVILY.equals(value)) {
                    valueInspected += comMarks.getInspectedImportantYesHeavily();
                    valueWhoChecks += comMarks.getWhochecksImportantYesHeavily();
                }
                if (ANSWER_NO.equals(value)) {
                    valueInspected += comMarks.getInspectedImportantNo();
                    valueWhoChecks += comMarks.getWhochecksImportantNo();
                }
            }
            if(PRIORITY_NOTIMPORTANT == priority) {
                if (ANSWER_YES_EASY.equals(value)) {
                    valueInspected += comMarks.getInspectedUnimportantYesEasy();
                    valueWhoChecks += comMarks.getWhochecksUnimportantYesEasy();
                }
                if (ANSWER_YES_HEAVILY.equals(value)) {
                    valueInspected += comMarks.getInspectedUnimportantYesHeavily();
                    valueWhoChecks +=  comMarks.getWhochecksUnimportantYesHeavily();
                }
                if (ANSWER_NO.equals(value)) {
                    valueInspected += comMarks.getInspectedUnimportantNo();
                    valueWhoChecks += comMarks.getWhochecksUnimportantNo();
                }
            }
        }
        else
            percent -= 1;
    }

    public int[] getMaximumCompatibility(List<Integer> values)
    {
        CompatibilityMarks comMarks = new CompatibilityMarks();
        int[] maxMark = new int[2];
        for(int q = 0;q<values.size();q++) {
            if(values.get(q) == 1)
            {
                maxMark [1] += comMarks.getWhochecksMaxMarkImportant();
                maxMark [0] += comMarks.getInspectedMaxMarkImportant();
            }
            if (values.get(q) == 0)
            {
                maxMark [1] += comMarks.getWhochecksMaxMarkUnimportant();
                maxMark [0] += comMarks.getInspectedMaxMarkUnimportant();
            }
        }
        return maxMark ;
    }
    public int getValueInspected()
    {
        return valueInspected;
    }
    public int getValueWhoChecks()
    {
        return valueWhoChecks;
    }
    public int getPercent()
    {
        return percent;
    }

}
