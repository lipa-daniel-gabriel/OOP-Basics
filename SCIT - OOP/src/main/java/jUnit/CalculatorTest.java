package jUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @org.junit.Test
    public void verifyMesurementUnitType() {
        boolean validation = true;
        String item = "cm";
        boolean actual = Calculator.measurementUnitsCheck(item);
        assertEquals(validation, actual);
    }

    @org.junit.Test
    public void calculateToUnitMeasureMM() {
        String expression = "10 cm + 1 m - 10 mm ";
        double actual = Calculator.expresionCalculatedInMM(expression);
        int expected = 1090;
        assertEquals(expected, actual, 0.00001);
    }

    @org.junit.Test
    public void unitConversion() {
        int number = 1;
        String unit = "cm";
        double actual = Calculator.unitConversion(number, unit);
        double expected = 10;
        assertEquals(expected, actual, 0.000001);
    }
}

