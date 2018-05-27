package tdd.kata.romannumeral.validation;

import org.junit.Test;
import tdd.kata.romannumeral.model.InputNumber;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputNumberThresholdValidatorTest {

    private InputNumberValidator validator;
    private InputNumber givenInputNumber;
    private ValidationResult actualResult;

    @Test
    public void givenInputNumberThatIsWithinThresholdShouldNotReturnAnError() {
        givenThresholdValidatorWithValues(1, 10);
        givenInputNumber(5);

        whenCallingValidatorService();

        thenShouldNotContainError();
    }

    @Test
    public void givenInputNumberThatIsGreaterThanMaximumThresholdShouldReturnAnError() {
        givenThresholdValidatorWithValues(5, 10);
        givenInputNumber(11);

        whenCallingValidatorService();

        thenShouldContainError();
        thenShouldContainErrorMessage("The input number has to be between 5 and 10.");
    }

    @Test
    public void givenInputNumberThatIsLessThanMaximumThresholdShouldReturnAnError() {
        givenThresholdValidatorWithValues(5, 10);
        givenInputNumber(4);

        whenCallingValidatorService();

        thenShouldContainError();
        thenShouldContainErrorMessage("The input number has to be between 5 and 10.");
    }

    private void thenShouldNotContainError() {
        assertThat(actualResult.hasError(), is(false));
    }

    private void thenShouldContainError() {
        assertThat(actualResult.hasError(), is(true));
    }

    private void thenShouldContainErrorMessage(String errorMessage) {
        assertThat(actualResult.getErrorMessage(), is(errorMessage));
    }

    private void whenCallingValidatorService() throws InputNumberValidationException {
        actualResult = validator.validate(givenInputNumber);
    }

    private void givenInputNumber(int number) {
        givenInputNumber = new InputNumber(number);
    }

    private void givenThresholdValidatorWithValues(int min, int max) {
        validator = new InputNumberThresholdValidator(min, max);
    }
}