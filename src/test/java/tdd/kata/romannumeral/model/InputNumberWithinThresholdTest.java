package tdd.kata.romannumeral.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputNumberWithinThresholdTest {

    private int givenMinimumThreshold;
    private int givenMaximumThreshold;
    private InputNumber givenInputValue;
    private boolean actualResult;

    @Test
    public void givenInputNumberIsWithinThresholdShouldPassValidation() {
        givenThresholdsWithMinimumAndMaximum(5, 10);
        givenInputNumber(7);

        whenValidatingInputNumber();

        thenValidationShouldPass();
    }

    @Test
    public void givenInputNumberIsEqualToMinimumThresholdShouldPassValidation() {
        givenThresholdsWithMinimumAndMaximum(5, 10);
        givenInputNumber(5);

        whenValidatingInputNumber();

        thenValidationShouldPass();
    }

    @Test
    public void givenInputNumberIsEqualToMaximumThresholdShouldPassValidation() {
        givenThresholdsWithMinimumAndMaximum(5, 10);
        givenInputNumber(10);

        whenValidatingInputNumber();

        thenValidationShouldPass();
    }

    @Test
    public void givenInputNumberIsOutsideMinimumThresholdShouldFailValidation() {
        givenThresholdsWithMinimumAndMaximum(5, 10);
        givenInputNumber(4);

        whenValidatingInputNumber();

        thenValidationShouldFail();
    }

    @Test
    public void givenInputNumberIsOutsideMaximumThresholdShouldFailValidation() {
        givenThresholdsWithMinimumAndMaximum(5, 10);
        givenInputNumber(11);

        whenValidatingInputNumber();

        thenValidationShouldFail();
    }

    private void thenValidationShouldPass() {
        assertThat(actualResult, is(true));
    }

    private void thenValidationShouldFail() {
        assertThat(actualResult, is(false));
    }

    private void whenValidatingInputNumber() {
        actualResult = givenInputValue.isWithinThreshold(givenMinimumThreshold, givenMaximumThreshold);
    }

    private void givenInputNumber(int inputValue) {
        givenInputValue = new InputNumber(inputValue);
    }

    private void givenThresholdsWithMinimumAndMaximum(int min, int max) {
        givenMinimumThreshold = min;
        givenMaximumThreshold = max;
    }
}