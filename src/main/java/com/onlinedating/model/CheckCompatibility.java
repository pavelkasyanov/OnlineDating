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
    public void check(int Priority,String value)
    {
        if(value.length() != 0) {
            if (PRIORITY_IMPORTANT == Priority)
            {
                if(ANSWER_YES_EASY.equals(value)) {
                    valueInspected += INSPECTED_IMPORTANT_YES_EASY;
                    valueWhoChecks += WHOCHECKS_IMPORTANT_YES_EASY;
                }
                if (ANSWER_YES_HEAVILY.equals(value)) {
                    valueInspected += INSPECTED_IMPORTANT_YES_HEAVY;
                    valueWhoChecks += WHOCHECKS_IMPORTANT_YES_HEAVY;
                }
                if (ANSWER_NO.equals(value)) {
                    valueInspected += INSPECTED_IMPORTANT_NO;
                    valueWhoChecks += WHOCHECKS_IMPORTANT_NO;
                }
            }
            if(PRIORITY_NOTIMPORTANT == 0) {
                if (ANSWER_YES_EASY.equals(value)) {
                    valueInspected += INSPECTED_NOTIMPORTANT_YES_EASY;
                    valueWhoChecks += WHOCHECKS_NOTIMPORTANT_YES_EASY;
                }
                if (ANSWER_YES_HEAVILY.equals(value)) {
                    valueInspected += INSPECTED_NOTIMPORTANT_YES_HEAVY;
                    valueWhoChecks += WHOCHECKS_NOTIMPORTANT_YES_HEAVY;
                }
                if (ANSWER_NO.equals(value)) {
                    valueInspected += INSPECTED_NOTIMPORTANT_NO;
                    valueWhoChecks += WHOCHECKS_NOTIMPORTANT_NO;
                }
            }
        }
        else
            percent -= 1;
    }

    public int[] getMaximumCompatibility(List<Integer> values)
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
