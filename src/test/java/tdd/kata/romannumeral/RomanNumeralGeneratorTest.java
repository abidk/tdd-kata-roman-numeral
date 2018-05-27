package tdd.kata.romannumeral;

import org.junit.Before;
import org.junit.Test;
import tdd.kata.romannumeral.service.RomanNumeralConverter;
import tdd.kata.romannumeral.service.RomanNumeralConverterImpl;
import tdd.kata.romannumeral.validation.InputNumberValidationException;
import tdd.kata.romannumeral.validation.InputNumberValidator;
import tdd.kata.romannumeral.validation.InputNumberThresholdValidator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralGeneratorTest {

    private static final int MINIMUM_NUMBER_THRESHOLD = 1;
    private static final int MAXIMUM_NUMBER_THRESHOLD = 3999;

    private RomanNumeralGenerator generator;
    private int givenNumber;
    private String actualResult;

    @Before
    public void setUp() {
        // doing full integration testing, otherwise can do mocks etc.
        RomanNumeralConverter converter = new RomanNumeralConverterImpl();
        InputNumberValidator validator = new InputNumberThresholdValidator(MINIMUM_NUMBER_THRESHOLD, MAXIMUM_NUMBER_THRESHOLD);

        generator = new RomanNumeralGeneratorImpl(validator, converter);
    }

    @Test
    public void whenGivenTheNumberOneThenCorrectRomanNumeralIsGenerated() throws InputNumberValidationException {
        givenNumber(1);

        whenGeneratingRomanNumeral();

        thenResultShouldEquals("I");
    }

    @Test
    public void whenGivenANumberCorrectRomanNumeralIsGenerated() throws InputNumberValidationException {
        givenNumber(600);

        whenGeneratingRomanNumeral();

        thenResultShouldEquals("DC");
    }

    @Test(expected=InputNumberValidationException.class)
    public void whenGivenANumberBelowThresholdThenExceptionIsThrown() throws InputNumberValidationException {
        givenNumber(0);

        whenGeneratingRomanNumeral();
    }

    @Test(expected=InputNumberValidationException.class)
    public void whenGivenANumberAboveThresholdThenExceptionIsThrown() throws InputNumberValidationException {
        givenNumber(4000);

        whenGeneratingRomanNumeral();
    }

    private void thenResultShouldEquals(String expectedResult) {
        assertThat(actualResult, is(expectedResult));
    }

    private void whenGeneratingRomanNumeral() throws InputNumberValidationException {
        actualResult = generator.generate(givenNumber);
    }

    private void givenNumber(int number) {
        givenNumber = number;
    }
}
