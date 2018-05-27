package tdd.kata.romannumeral.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralResultTest {

    private RomanNumeralResult result;
    private String actualResult;

    @Before
    public void setUp() {
        result = new RomanNumeralResult();
    }

    @Test
    public void appendingRomanNumeralValuesShouldReturnCorrectRomanNumeralValue() {
        givenResultValue(RomanNumeral.M);
        givenResultValue(RomanNumeral.IX);
        givenResultValue(RomanNumeral.C);

        whenRetrievingText();

        thenResultShouldEqualValue("MIXC");
    }

    private void thenResultShouldEqualValue(String expectedValue) {
        assertEquals(actualResult, expectedValue);
    }

    private void whenRetrievingText() {
        actualResult = result.getTextValue();
    }

    private void givenResultValue(RomanNumeral numeral) {
        result.append(numeral);
    }
}