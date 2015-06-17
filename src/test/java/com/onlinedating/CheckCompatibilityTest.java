package com.onlinedating;

import org.junit.Test;

import static com.onlinedating.model.CompatibilityAnswers.ANSWER_YES_EASY;
import static com.onlinedating.model.CompatibilityAnswers.ANSWER_YES_HEAVILY;
import static org.junit.Assert.assertEquals;

/**
 * Created by Кирилл on 17.06.15.
 */
public class CheckCompatibilityTest {
    @Test
    public void testCheck() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        cC.check(0,"");
        assertEquals(-1, cC.getPersent());
        cC.check(1,ANSWER_YES_EASY);
        assertEquals(5,cC.getValueWoman());
        cC.check(0,ANSWER_YES_HEAVILY);
        assertEquals(5,cC.getValueWoman());
    }

    @Test
    public void testGetValueWoman() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        assertEquals(0, cC.getValueWoman());
    }

    @Test
    public void testGetValueMan() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        assertEquals(0,cC.getValueMan());
    }

    @Test
    public void testGetPersent() throws Exception {
        CheckCompatibility cC = new CheckCompatibility();
        assertEquals(0,cC.getPersent());
    }

    @Test
    public void testChechSum() throws Exception {

    }
}
