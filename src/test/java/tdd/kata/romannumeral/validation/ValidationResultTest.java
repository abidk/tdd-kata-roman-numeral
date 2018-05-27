package tdd.kata.romannumeral.validation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidationResultTest {

    private ValidationResult result;

    @Test
    public void givenAResultThatContainsAnErrorThenResultIsCorrect() {
        givenAResultWithError("error");

        thenResultHasError();
        thenResultHasErrorMessage("error");
    }

    @Test
    public void givenAResultWithNoErrorThenResultIsCorrect() {
        givenAResultWithNoError();

        thenResultHasNoError();
        thenResultHasErrorMessage(null);
    }

    private void thenResultHasErrorMessage(String error) {
        assertThat(result.getErrorMessage(), is(error));
    }

    private void thenResultHasNoError() {
        assertThat(result.hasError(), is(false));
    }

    private void thenResultHasError() {
        assertThat(result.hasError(), is(true));
    }

    private void givenAResultWithError(String error) {
        result = new ValidationResult();
        result.setErrorMessage(error);
    }

    private void givenAResultWithNoError() {
        result = new ValidationResult();
    }
}