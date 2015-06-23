package com.onlinedating;

import com.onlinedating.service.CheckCompatibility;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static com.onlinedating.service.CompatibilityAnswers.*;

public class CheckCompatibilityTest2 {
    CheckCompatibility cC;
    public CheckCompatibilityTest2(){
        //TODO load properties
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
        cC.check(0,"");
        assertEquals(-1, cC.getPercent());
        cC.check(1,ANSWER_YES_EASY);
        assertEquals(5,cC.getValueQuestioner());
        assertEquals(5,cC.getValueRespondent());
        cC.check(1,ANSWER_YES_HEAVILY);
        assertEquals(8,cC.getValueQuestioner());
        assertEquals(4,cC.getValueRespondent());
        cC.check(1,ANSWER_NO);
        assertEquals(4,cC.getValueQuestioner());
        assertEquals(7,cC.getValueRespondent());
        cC.check(0,ANSWER_YES_EASY);
        assertEquals(6,cC.getValueQuestioner());
        assertEquals(9,cC.getValueRespondent());
        cC.check(0,ANSWER_YES_HEAVILY);
        assertEquals(6,cC.getValueQuestioner());
        assertEquals(7,cC.getValueRespondent());
        cC.check(0,ANSWER_NO);
        assertEquals(8,cC.getValueQuestioner());
        assertEquals(11,cC.getValueRespondent());
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
        List<Integer> li = new ArrayList<Integer>(4);
        li.add(1);
        li.add(0);
        li.add(0);
        li.add(1);
        int[] a = cC.getMaximumCompatibility(li);
        assertEquals(18,a[1]);
        assertEquals(14,a[0]);
    }
}
