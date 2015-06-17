package com.onlinedating;

import com.onlinedating.model.checkCompatibility;
import org.junit.Test;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Кирилл on 17.06.15.
 */
public class checkCompatibilityTest {
    @Test
    public void testCheck() throws Exception {
        checkCompatibility cC = new checkCompatibility();
        cC.Check(0,"");
        assertEquals(-1, cC.getPersent());
        cC.Check(1,"I'll do it (easily)");
        assertEquals(5,cC.getValueWoman());
        cC.Check(0,"I'll do it (heavily)");
        assertEquals(5,cC.getValueWoman());
    }

    @Test
    public void testGetValueWoman() throws Exception {
        checkCompatibility cC = new checkCompatibility();
        assertEquals(0, cC.getValueWoman());
    }

    @Test
    public void testGetValueMan() throws Exception {
        checkCompatibility cC = new checkCompatibility();
        assertEquals(0,cC.getValueMan());
    }

    @Test
    public void testGetPersent() throws Exception {
        checkCompatibility cC = new checkCompatibility();
        assertEquals(0,cC.getPersent());
    }

    @Test
    public void testChechSum() throws Exception {

    }
}
