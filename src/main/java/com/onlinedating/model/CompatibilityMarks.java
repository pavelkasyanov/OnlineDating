package com.onlinedating.model;

import com.sun.java.util.jar.pack.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import pack.analize.*;
/**
 * Created by Кирилл on 17.06.15.
 */

public class CompatibilityMarks {
    final static String DEFAULT_FILE_NAME= "prop.properties";

    private int[] marks = new int[12];

    private int inspectedMaxMarkImportant;
    private int whochecksMaxMarkImportant;
    private int inspectedMaxMarkUnimportant;
    private int whochecksMaxMarkUnimportant;

    private int inspectedImportantYesEasy;
    private int inspectedImportantYesHeavily;
    private int inspectedImportantNo;
    private int whochecksImportantYesEasy;
    private int whochecksImportantYesHeavily;
    private int whochecksImportantNo;

    private int inspectedUnimportantYesEasy;
    private int inspectedUnimportantYesHeavily;
    private int inspectedUnimportantNo;
    private int whochecksUnimportantYesEasy;
    private int whochecksUnimportantYesHeavily;
    private int whochecksUnimportantNo;

    public void loadProperties(String fileName){
        PropertiesAnalizatorMap propAnaliz = new PropertiesAnalizatorMap();
        marks[0] = inspectedImportantYesEasy = Integer.parseInt(propAnaliz.matched("INSPECTED_IMPORTANT_YES_EASY"));
        marks[1] = inspectedImportantYesHeavily = Integer.parseInt(propAnaliz.matched("INSPECTED_IMPORTANT_YES_HEAVY"));
        marks[2] = inspectedImportantNo = Integer.parseInt(propAnaliz.matched("INSPECTED_IMPORTANT_NO"));
        marks[3] = whochecksImportantYesEasy = Integer.parseInt(propAnaliz.matched("WHOCHECKS_IMPORTANT_YES_EASY"));
        marks[4] = whochecksImportantYesHeavily = Integer.parseInt(propAnaliz.matched("WHOCHECKS_IMPORTANT_YES_HEAVY"));
        marks[5] = whochecksImportantNo = Integer.parseInt(propAnaliz.matched("WHOCHECKS_IMPORTANT_NO"));

        marks[6] = inspectedUnimportantYesEasy = Integer.parseInt(propAnaliz.matched("INSPECTED_UNIMPORTANT_YES_EASY"));
        marks[7] = inspectedUnimportantYesHeavily = Integer.parseInt(propAnaliz.matched("INSPECTED_UNIMPORTANT_YES_HEAVY"));
        marks[8] = inspectedUnimportantNo = Integer.parseInt(propAnaliz.matched("INSPECTED_UNIMPORTANT_NO"));
        marks[9] = whochecksUnimportantYesEasy = Integer.parseInt(propAnaliz.matched("WHOCHECKS_UNIMPORTANT_YES_EASY"));
        marks[10] = whochecksUnimportantYesHeavily = Integer.parseInt(propAnaliz.matched("WHOCHECKS_UNIMPORTANT_YES_HEAVY"));
        marks[11] = whochecksUnimportantNo = Integer.parseInt(propAnaliz.matched("WHOCHECKS_UNIMPORTANT_NO"));
        calculateMaxPossibleValues();

    }

    public void calculateMaxPossibleValues(){
        // 4 for for all 4 variables
        inspectedMaxMarkImportant = 0;
        for(int i = 0; i< 3;i++){
            if(marks[i] > inspectedMaxMarkImportant)
                inspectedMaxMarkImportant = marks[i];
        }
        whochecksMaxMarkImportant = 0;
        for(int i = 3; i< 6;i++){
            if(marks[i] > whochecksMaxMarkImportant)
                whochecksMaxMarkImportant = marks[i];
        }
        inspectedMaxMarkUnimportant = 0;
        for(int i = 6; i< 9;i++){
            if(marks[i] > inspectedMaxMarkUnimportant)
            inspectedMaxMarkUnimportant = marks[i];
        }
        whochecksMaxMarkUnimportant = 0;
        for(int i = 9; i< 12;i++){
            if(marks[i] > whochecksMaxMarkUnimportant)
                whochecksMaxMarkUnimportant = marks[i];
        }

    }

    public int getInspectedMaxMarkImportant() {
        return  inspectedMaxMarkImportant;
    }
    public int getWhochecksMaxMarkImportant() {
        return  whochecksMaxMarkImportant;
    }
    public int getInspectedMaxMarkUnimportant() {
        return  inspectedMaxMarkUnimportant;
    }
    public int getWhochecksMaxMarkUnimportant() {
        return  whochecksMaxMarkUnimportant;
    }

    public int getInspectedImportantYesEasy() {
        return  inspectedImportantYesEasy;
    }
    public int getInspectedImportantYesHeavily() {
        return  inspectedImportantYesHeavily;
    }
    public  int getInspectedImportantNo() {
        return inspectedImportantNo;
    }
    public int getWhochecksImportantYesEasy() {
        return whochecksImportantYesEasy;
    }
    public int getWhochecksImportantYesHeavily() {
        return whochecksImportantYesHeavily;
    }
    public int getWhochecksImportantNo() {
        return whochecksImportantNo;
    }
    public int getInspectedUnimportantYesEasy() {
        return inspectedUnimportantYesEasy;
    }
    public int getInspectedUnimportantYesHeavily() {
        return inspectedUnimportantYesHeavily;
    }
    public  int getInspectedUnimportantNo() {
        return inspectedUnimportantNo;
    }
    public int getWhochecksUnimportantYesEasy() {
        return whochecksUnimportantYesEasy;
    }
    public int getWhochecksUnimportantYesHeavily() {
        return whochecksUnimportantYesHeavily;
    }
    public int getWhochecksUnimportantNo() {
        return whochecksUnimportantNo;
    }



}