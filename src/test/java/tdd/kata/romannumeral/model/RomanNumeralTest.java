package tdd.kata.romannumeral.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RomanNumeralTest {

    private int givenNumber;
    private RomanNumeral actualResult;

    @Test
    public void whenNumberIsZeroThenShouldReturnNull() {
        givenANumber(0);

        whenRetrievingHighestNumeral();

        thenShouldMatchExpectedResult(null);
    }

    @Test
    public void whenNumberIsOneThenShouldReturnCorrectRomanNumeral() {
        givenANumber(1);

        whenRetrievingHighestNumeral();

        thenShouldMatchExpectedResult(RomanNumeral.I);
    }

    @Test
    public void whenNumberIs500ThenShouldReturnCorrectRomanNumeral() {
        givenANumber(600);

        whenRetrievingHighestNumeral();

        thenShouldMatchExpectedResult(RomanNumeral.D);
    }

    @Test
    public void whenNumberIs3000ThenShouldReturnCorrectRomanNumeral() {
        givenANumber(3000);

        whenRetrievingHighestNumeral();

        thenShouldMatchExpectedResult(RomanNumeral.M);
    }

    private void thenShouldMatchExpectedResult(RomanNumeral expectedResult) {
        assertThat(actualResult, is(expectedResult));
    }

    private void whenRetrievingHighestNumeral() {
        actualResult = RomanNumeral.getHighestRomanNumeral(givenNumber);
    }

    private void givenANumber(int number) {
        givenNumber = number;
    }

}