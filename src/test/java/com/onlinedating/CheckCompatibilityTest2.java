package com.onlinedating;

import com.onlinedating.model.CheckCompatibility;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static com.onlinedating.model.CompatibilityAnswers.*;
/**
 * Created by Кирилл on 17.06.15.
 */
public class CheckCompatibilityTest2 {
    @Test
    public void testCheck() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        cC.check(0,"");
        assertEquals(-1, cC.getPercent());
//1
        cC.check(1,ANSWER_YES_EASY);
        assertEquals(5,cC.getValueInspected());
        assertEquals(5,cC.getValueWhoChecks());
        cC.check(1,ANSWER_YES_HEAVILY);
        assertEquals(8,cC.getValueInspected());
        assertEquals(4,cC.getValueWhoChecks());
        cC.check(1,ANSWER_NO);
        assertEquals(4,cC.getValueInspected());
        assertEquals(7,cC.getValueWhoChecks());
        cC.check(0,ANSWER_YES_EASY);
        assertEquals(6,cC.getValueInspected());
        assertEquals(9,cC.getValueWhoChecks());
        cC.check(0,ANSWER_YES_HEAVILY);
        assertEquals(6,cC.getValueInspected());
        assertEquals(7,cC.getValueWhoChecks());
        cC.check(0,ANSWER_NO);
        assertEquals(8,cC.getValueInspected());
        assertEquals(11,cC.getValueWhoChecks());
    }

    @Test
    public void testGetValueWoman() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        assertEquals(0, cC.getValueInspected());
    }

    @Test
    public void testGetValueMan() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        assertEquals(0,cC.getValueWhoChecks());
    }

    @Test
    public void testGetPercent() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        assertEquals(0,cC.getPercent());
    }

    @Test
    public void testCheckSum() throws Exception {
        List<Integer> li = new ArrayList<Integer>(4);
        li.add(1);li.add(0);li.add(0); li.add(1);
        CheckCompatibility cC = new CheckCompatibility();
        int[] a = cC.getMaximumCompatibility(li);
        assertEquals(16,a[1]);
        assertEquals(14,a[0]);
    }
}
