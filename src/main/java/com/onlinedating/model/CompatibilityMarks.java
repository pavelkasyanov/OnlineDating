package com.onlinedating.model;

import com.sun.java.util.jar.pack.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Кирилл on 17.06.15.
 */

public class CompatibilityMarks {
    final static String DEFAULT_FILE_NAME= "compatibilityMarks.properties";

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

    void loadProperties(String fileName){
        if(!new File(fileName).exists()) {
            fileName = DEFAULT_FILE_NAME;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0 ;
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    marks[i] = analyzeConfigFile(s);
                    i++;
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    // setting values
   // inspectedImportantYesEasy = props.getProperty(INSPECTED_IMPORTANT_YES_EASY);

    // calculate max values
        calculateMaxPossibleValues();

    }

    private int analyzeConfigFile(String analyzedString){
        if(analyzedString.contains("INSPECTED")) {
            if (analyzedString.contains("UNIMPORTANT")) {
                if (analyzedString.contains("EASY")) {
                    inspectedUnimportantYesEasy = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("HEAVY")) {
                    inspectedUnimportantYesHeavily = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("NO")) {
                    inspectedUnimportantNo = analyzeFindInt(analyzedString);
                }
            } else {
                if (analyzedString.contains("EASY")) {
                    inspectedImportantYesEasy = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("HEAVY")) {
                    inspectedImportantYesHeavily = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("NO")) {
                    inspectedImportantNo = analyzeFindInt(analyzedString);
                }
            }
        }
        else
        {
            if (analyzedString.contains("UNIMPORTANT")) {
                if (analyzedString.contains("EASY")) {
                    whochecksUnimportantYesEasy = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("HEAVY")) {
                    whochecksUnimportantYesHeavily = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("NO")) {
                    whochecksUnimportantNo = analyzeFindInt(analyzedString);
                }
            } else {
                if (analyzedString.contains("EASY")) {
                    whochecksImportantYesEasy = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("HEAVY")) {
                    whochecksImportantYesHeavily = analyzeFindInt(analyzedString);
                }
                if (analyzedString.contains("NO")) {
                    whochecksImportantNo = analyzeFindInt(analyzedString);
                }
            }
        }
        return analyzeFindInt(analyzedString);
    }
    private int analyzeFindInt(String analyzedString){
        int startPosition = analyzedString.indexOf('=');
        int finishPosition = analyzedString.indexOf(';');
        char letter;
        String world = "";
        for ( int i = startPosition;i<finishPosition;i++) {
            letter = analyzedString.charAt(i);
            if(letter != ' '){
                world += letter;
            }
        }
        return Integer.parseInt(world);
    }



    private void calculateMaxPossibleValues(){
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