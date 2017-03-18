package at.sw2017.calculator;

/**
 * Created by feldh on 15.03.2017.
 */
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class CalculatorUniTest {
    @Test
    public void testDoAddition() {
        int result = Calculations.doAddition(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testDoSubtraction() {
        int result = Calculations.doSubtraction(7, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDoMultiplication() {
        int result = Calculations.doMultiplication(2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testDoDivision() {
        int result = Calculations.doDivision(8, 4);
        assertEquals(2, result);
    }

    @Test
    public void testDoDivision1() {
        int result = Calculations.doDivision(8, 0);
        assertEquals(0, result);
    }

    @Test
    public void testDoDivision2() {
        int result = Calculations.doDivision(11, 4);
        assertEquals(2, result);
    }
}