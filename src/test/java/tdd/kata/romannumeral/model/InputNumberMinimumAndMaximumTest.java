package tdd.kata.romannumeral.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputNumberMinimumAndMaximumTest {

    private int givenThresholdValue;
    private InputNumber givenInputNumber;

    @Test
    public void givenInputNumberIsLessThanThresholdThenShouldPassValidation() {
        givenThresholdValue(3);
        givenInputNumber(1);

        thenInputNumberIsEqualOrLessThanThreshold();
    }

    @Test
    public void givenInputNumberIsNotLessThanThresholdThenShouldPassValidation() {
        givenThresholdValue(3);
        givenInputNumber(6);

        thenInputNumberIsNotEqualOrLessThanThreshold();
    }

    @Test
    public void givenInputNumberIsEqualWithThresholdThenShouldPassValidation() {
        givenThresholdValue(6);
        givenInputNumber(6);

        thenInputNumberIsEqualOrLessThanThreshold();
    }

    @Test
    public void givenInputNumberIsGreaterThanThresholdThenShouldPassValidation() {
        givenThresholdValue(3);
        givenInputNumber(6);

        thenNumberIsEqualOrGreaterThanThreshold();
    }

    @Test
    public void givenInputNumberIsNotGreaterThanThresholdThenShouldPassValidation() {
        givenThresholdValue(3);
        givenInputNumber(1);

        thenNumberIsNotEqualOrGreaterThanThreshold();
    }

    @Test
    public void givenInputNumberIsEqualsWithThresholdThenShouldPassValidation() {
        givenThresholdValue(6);
        givenInputNumber(6);

        thenNumberIsEqualOrGreaterThanThreshold();
    }

    private void givenThresholdValue(int thresholdValue) {
        givenThresholdValue = thresholdValue;
    }
    
    private void givenInputNumber(int inputValue) {
        givenInputNumber = new InputNumber(inputValue);
    }

    private void thenInputNumberIsEqualOrLessThanThreshold() {
        assertThat(givenInputNumber.isEqualOrLowerThan(givenThresholdValue), is(true));
    }

    private void thenInputNumberIsNotEqualOrLessThanThreshold() {
        assertThat(givenInputNumber.isEqualOrLowerThan(givenThresholdValue), is(false));
    }

    private void thenNumberIsEqualOrGreaterThanThreshold() {
        assertThat(givenInputNumber.isEqualOrGreaterThan(givenThresholdValue), is(true));
    }

    private void thenNumberIsNotEqualOrGreaterThanThreshold() {
        assertThat(givenInputNumber.isEqualOrGreaterThan(givenThresholdValue), is(false));
    }
}