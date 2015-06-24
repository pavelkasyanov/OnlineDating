package com.onlinedating;

import com.onlinedating.service.CheckCompatibility;
import com.onlinedating.service.CompatibilityMarks;
import org.junit.Test;
import static com.onlinedating.service.CompatibilityAnswers.PRIORITY_IMPORTANT;
import static com.onlinedating.service.CompatibilityAnswers.PRIORITY_UNIMPORTANT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static com.onlinedating.service.CompatibilityAnswers.*;

public class CheckCompatibilityTest2 {
    static final String CONFIG_FILE_NAME = "src/main/resources/configCompatibility.properties";
    CheckCompatibility cC;
    public CheckCompatibilityTest2(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/configCompatibility.properties");
            cC = new CheckCompatibility(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testCheck() throws Exception {
        CompatibilityMarks cm = new CompatibilityMarks();
        cm.loadProperties(CONFIG_FILE_NAME);
        int valueQuestioner = 0,valueRespondent = 0;

        cC.check(PRIORITY_UNIMPORTANT,"");
        assertEquals(-1, cC.getPercent());
        cC.check(PRIORITY_IMPORTANT,ANSWER_YES_EASY);
        valueQuestioner += cm.getImportantYesEasyQuestioner();
        valueRespondent += cm.getImportantYesEasyRespondent();
        assertEquals(valueQuestioner,cC.getValueQuestioner());
        assertEquals(valueRespondent,cC.getValueRespondent());
        cC.check(PRIORITY_IMPORTANT,ANSWER_YES_HEAVILY);
        valueQuestioner +=cm.getImportantYesHeavilyQuestioner();
        valueRespondent +=cm.getImportantYesHeavilyRespondent();
        assertEquals(valueQuestioner,cC.getValueQuestioner());
        assertEquals(valueRespondent,cC.getValueRespondent());
        cC.check(PRIORITY_IMPORTANT,ANSWER_NO);
        valueQuestioner +=cm.getImportantNoQuestioner();
        valueRespondent +=cm.getImportantNoRespondent();
        assertEquals(valueQuestioner,cC.getValueQuestioner());
        assertEquals(valueRespondent,cC.getValueRespondent());
        cC.check(PRIORITY_UNIMPORTANT,ANSWER_YES_EASY);
        valueQuestioner +=cm.getUnimportantYesEasyQuestioner();
        valueRespondent +=cm.getUnimportantYesEasyRespondent();
        assertEquals(valueQuestioner,cC.getValueQuestioner());
        assertEquals(valueRespondent,cC.getValueRespondent());
        cC.check(PRIORITY_UNIMPORTANT,ANSWER_YES_HEAVILY);
        valueQuestioner +=cm.getUnimportantYesHeavilyQuestioner();
        valueRespondent +=cm.getUnimportantYesHeavilyRespondent();
        assertEquals(valueQuestioner,cC.getValueQuestioner());
        assertEquals(valueRespondent,cC.getValueRespondent());
        cC.check(PRIORITY_UNIMPORTANT,ANSWER_NO);
        valueQuestioner +=cm.getUnimportantNoQuestioner();
        valueRespondent +=cm.getUnimportantNoRespondent();
        assertEquals(valueQuestioner,cC.getValueQuestioner());
        assertEquals(valueRespondent,cC.getValueRespondent());
    }

    @Test
    public void testGetValueWoman() throws Exception {
        assertEquals(0, cC.getValueQuestioner());
    }

    @Test
    public void testGetValueMan() throws Exception {
        assertEquals(0,cC.getValueRespondent());
    }

    @Test
    public void testGetPercent() throws Exception {
        assertEquals(0,cC.getPercent());
    }

    @Test
    public void testGetMaximumCompatibility() throws Exception {
        CompatibilityMarks cm = new CompatibilityMarks();
        cm.loadProperties(CONFIG_FILE_NAME);
        List<Integer> li = new ArrayList<Integer>(4);
        li.add(PRIORITY_IMPORTANT);
        li.add(PRIORITY_UNIMPORTANT);
        li.add(PRIORITY_UNIMPORTANT);
        li.add(PRIORITY_IMPORTANT);
        int[] compatibility = cC.getMaximumCompatibility(li);
        int questioner = cm.getMaxMarkImportantQuestioner() + cm.getMaxMarkUnimportantQuestioner()
                + cm.getMaxMarkUnimportantQuestioner() + cm.getMaxMarkImportantQuestioner();
        int respondent = cm.getMaxMarkImportantRespondent() + cm.getMaxMarkUnimportantRespondent()
                + cm.getMaxMarkUnimportantRespondent() + cm.getMaxMarkImportantRespondent();
        assertEquals(questioner,compatibility[0]);
        assertEquals(respondent,compatibility[1]);
    }
}
