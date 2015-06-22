package com.onlinedating.service;

import java.io.InputStream;
import java.util.List;
import static com.onlinedating.service.CompatibilityAnswers.PRIORITY_IMPORTANT;
import static com.onlinedating.service.CompatibilityAnswers.PRIORITY_UNIMPORTANT;
/**
 * Created by Кирилл on 17.06.15.
 */

public class CheckCompatibility {
    private int valueQuestioner = 0;
    private int valueRespondent = 0;
    private int percent = 0;
    private final CompatibilityMarks comMarks;

    public CheckCompatibility(InputStream resourceAsStream) {
        comMarks = new CompatibilityMarks();
        comMarks.loadProperties(resourceAsStream);
    }

    public void check(int priority, String value)
    {

        if((value != null)&&(!"".equals(value))) {
            if (PRIORITY_IMPORTANT == priority)
            {
                if(CompatibilityAnswers.ANSWER_YES_EASY.equals(value)) {
                    valueQuestioner += comMarks.getImportantYesEasyQuestioner();
                     valueRespondent += comMarks.getImportantYesEasyRespondent();
                }
                if (CompatibilityAnswers.ANSWER_YES_HEAVILY.equals(value)) {
                    valueQuestioner += comMarks.getImportantYesHeavilyQuestioner();
                    valueRespondent += comMarks.getImportantYesHeavilyRespondent();
                }
                if (CompatibilityAnswers.ANSWER_NO.equals(value)) {
                    valueQuestioner += comMarks.getImportantNoQuestioner();
                    valueRespondent += comMarks.getImportantNoRespondent();
                }
            }
            if(PRIORITY_UNIMPORTANT == priority) {
                if (CompatibilityAnswers.ANSWER_YES_EASY.equals(value)) {
                    valueQuestioner += comMarks.getUnimportantYesEasyQuestioner();
                    valueRespondent += comMarks.getUnimportantYesEasyRespondent();
                }
                if (CompatibilityAnswers.ANSWER_YES_HEAVILY.equals(value)) {
                    valueQuestioner += comMarks.getUnimportantYesHeavilyQuestioner();
                    valueRespondent +=  comMarks.getUnimportantYesHeavilyRespondent();
                }
                if (CompatibilityAnswers.ANSWER_NO.equals(value)) {
                    valueQuestioner += comMarks.getUnimportantNoQuestioner();
                    valueRespondent += comMarks.getUnimportantNoRespondent();
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
                maxMark [0] += comMarks.getMaxMarkImportantQuestioner();
                maxMark [1] += comMarks.getMaxMarkImportantRespondent();
            }
            if (values.get(q) == 0)
            {
                maxMark [0] += comMarks.getMaxMarkUnimportantQuestioner();
                maxMark [1] += comMarks.getMaxMarkUnimportantRespondent();
            }
        }
        return maxMark ;
    }
    public int getValueQuestioner()
    {
        return valueQuestioner;
    }
    public int getValueRespondent()
    {
        return valueRespondent;
    }
    public int getPercent()
    {
        return percent;
    }

}
