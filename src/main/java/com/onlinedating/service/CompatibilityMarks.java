package com.onlinedating.service;

import com.sun.java.util.jar.pack.*;


import java.io.*;
import java.util.Properties;


/**
 * Created by Кирилл on 17.06.15.
 */

public class CompatibilityMarks {
    final static String DEFAULT_FILE_NAME= "configCompatibility.properties";

    public static final String IMPORTANT_YES_EASY_QUESTIONER= "important.yes.easy.questioner";
    public static final String IMPORTANT_YES_HEAVY_QUESTIONER= "important.yes.heavy.questioner";
    public static final String IMPORTANT_NO_QUESTIONER = "important.no.questioner";
    public static final String IMPORTANT_YES_EASY_RESPONDENT = "important.yes.easy.respondent";
    public static final String IMPORTANT_YES_HEAVY_RESPONDENT = "important.yes.heavy.respondent";
    public static final String IMPORTANT_NO_RESPONDENT = "important.no.respondent";
    public static final String UNIMPORTANT_YES_EASY_QUESTIONER = "unimportant.yes.easy.questioner";
    public static final String UNIMPORTANT_YES_HEAVY_QUESTIONER = "unimportant.yes.heavy.questioner";
    public static final String UNIMPORTANT_NO_QUESTIONER = "unimportant.no.questioner";
    public static final String UNIMPORTANT_YES_EASY_RESPONDENT = "unimportant.yes.easy.respondent";
    public static final String UNIMPORTANT_YES_HEAVY_RESPONDENT = "unimportant.yes.heavy.respondent";
    public static final String UNIMPORTANT_NO_RESPONDENT = "unimportant.no.respondent";

    private int[] marks = new int[12];

    private int maxMarkImportantQuestioner;
    private int maxMarkImportantRespondent;
    private int maxMarkUnimportantQuestioner;
    private int maxMarkUnimportantRespondent;

    private int importantYesEasyQuestioner;
    private int importantYesHeavilyQuestioner;
    private int importantNoQuestioner;
    private int importantYesEasyRespondent;
    private int importantYesHeavilyRespondent;
    private int importantNoRespondent;

    private int unimportantYesEasyQuestioner;
    private int unimportantYesHeavilyQuestioner;
    private int unimportantNoQuestioner;
    private int unimportantYesEasyRespondent;
    private int unimportantYesHeavilyRespondent;
    private int unimportantNoRespondent;

    public void loadProperties(InputStream resourceAsStream) {
        Properties props = new Properties();
               try {
            props.load(resourceAsStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        marks[0] = importantYesEasyQuestioner = Integer.parseInt(props.getProperty(IMPORTANT_YES_EASY_QUESTIONER));
        marks[1] = importantYesHeavilyQuestioner = Integer.parseInt(props.getProperty(IMPORTANT_YES_HEAVY_QUESTIONER));
        marks[2] = importantNoQuestioner = Integer.parseInt(props.getProperty(IMPORTANT_NO_QUESTIONER));
        marks[3] = importantYesEasyRespondent = Integer.parseInt(props.getProperty(IMPORTANT_YES_EASY_RESPONDENT));
        marks[4] = importantYesHeavilyRespondent = Integer.parseInt(props.getProperty(IMPORTANT_YES_HEAVY_RESPONDENT));
        marks[5] = importantNoRespondent = Integer.parseInt(props.getProperty(IMPORTANT_NO_RESPONDENT));

        marks[6] = unimportantYesEasyQuestioner = Integer.parseInt(props.getProperty(UNIMPORTANT_YES_EASY_QUESTIONER));
        marks[7] = unimportantYesHeavilyQuestioner = Integer.parseInt(props.getProperty(UNIMPORTANT_YES_HEAVY_QUESTIONER));
        marks[8] = unimportantNoQuestioner = Integer.parseInt(props.getProperty(UNIMPORTANT_NO_QUESTIONER));
        marks[9] = unimportantYesEasyRespondent = Integer.parseInt(props.getProperty(UNIMPORTANT_YES_EASY_RESPONDENT));
        marks[10] = unimportantYesHeavilyRespondent = Integer.parseInt(props.getProperty(UNIMPORTANT_YES_HEAVY_RESPONDENT));
        marks[11] = unimportantNoRespondent = Integer.parseInt(props.getProperty(UNIMPORTANT_NO_RESPONDENT));
        calculateMaxPossibleValues();
    }
    public void calculateMaxPossibleValues(){
        maxMarkImportantQuestioner = 0;
        for(int i = 0; i< 3;i++){
            if(marks[i] > maxMarkImportantQuestioner)
                maxMarkImportantQuestioner = marks[i];
        }
        maxMarkImportantRespondent = 0;
        for(int i = 3; i< 6;i++){
            if(marks[i] > maxMarkImportantRespondent)
                maxMarkImportantRespondent = marks[i];
        }
        maxMarkUnimportantQuestioner = 0;
        for(int i = 6; i< 9;i++){
            if(marks[i] > maxMarkUnimportantQuestioner)
                maxMarkUnimportantQuestioner = marks[i];
        }
        maxMarkUnimportantRespondent = 0;
        for(int i = 9; i< 12;i++){
            if(marks[i] > maxMarkUnimportantRespondent)
                maxMarkUnimportantRespondent = marks[i];
        }

    }

    public int getMaxMarkImportantQuestioner() {
        return  maxMarkImportantQuestioner;
    }
    public int getMaxMarkImportantRespondent() {
        return  maxMarkImportantRespondent;
    }
    public int getMaxMarkUnimportantQuestioner() {
        return  maxMarkUnimportantQuestioner;
    }
    public int getMaxMarkUnimportantRespondent() {
        return  maxMarkUnimportantRespondent;
    }

    public int getImportantYesEasyQuestioner() {
        return  importantYesEasyQuestioner;
    }
    public int getImportantYesHeavilyQuestioner() {
        return  importantYesHeavilyQuestioner;
    }
    public int getImportantNoQuestioner() {
        return importantNoQuestioner;
    }
    public int getImportantYesEasyRespondent() {
        return importantYesEasyRespondent;
    }
    public int getImportantYesHeavilyRespondent() {
        return importantYesHeavilyRespondent;
    }
    public int getImportantNoRespondent() {
        return importantNoRespondent;
    }
    public int getUnimportantYesEasyQuestioner() {
        return unimportantYesEasyQuestioner;
    }
    public int getUnimportantYesHeavilyQuestioner() {
        return unimportantYesHeavilyQuestioner;
    }
    public int getUnimportantNoQuestioner() {
        return unimportantNoQuestioner;
    }
    public int getUnimportantYesEasyRespondent() {
        return unimportantYesEasyRespondent;
    }
    public int getUnimportantYesHeavilyRespondent() {
        return unimportantYesHeavilyRespondent;
    }
    public int getUnimportantNoRespondent() {
        return unimportantNoRespondent;
    }



}