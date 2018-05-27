package tdd.kata.romannumeral.service;

import org.junit.Before;
import org.junit.Test;
import tdd.kata.romannumeral.model.InputNumber;
import tdd.kata.romannumeral.model.RomanNumeralResult;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RomanNumeralConverterImplTest {

    private RomanNumeralConverter converter;
    private InputNumber givenInputNumber;
    private RomanNumeralResult actualResult;

    @Before
    public void setUp() {
        converter = new RomanNumeralConverterImpl();
    }

    @Test
    public void passingValueOneParameterShouldReturnValue_I() {
        givenInputNumber(1);

        whenCallingConverter();

        thenShouldMatchRomanNumeral("I");
    }

    @Test
    public void passingValueFiveParameterShouldReturnValue_V() {
        givenInputNumber(5);

        whenCallingConverter();

        thenShouldMatchRomanNumeral("V");
    }

    @Test
    public void passingValueTenParameterShouldReturnValue_X() {
        givenInputNumber(10);

        whenCallingConverter();

        thenShouldMatchRomanNumeral("X");
    }

    @Test
    public void passingValueTwentyParameterShouldReturnValue_XX() {
        givenInputNumber(20);

        whenCallingConverter();

        thenShouldMatchRomanNumeral("XX");
    }

    @Test
    public void passingValue3999ShouldReturnValue_MMMCMXCIX() {
        givenInputNumber(3999);

        whenCallingConverter();

        thenShouldMatchRomanNumeral("MMMCMXCIX");
    }

    private void thenShouldMatchRomanNumeral(String expectedValue) {
        assertThat(actualResult.toString(), is(expectedValue));
    }

    private void whenCallingConverter() {
        actualResult = converter.convert(givenInputNumber);
    }

    private void givenInputNumber(final int number) {
        givenInputNumber = new InputNumber(number);
    }

}