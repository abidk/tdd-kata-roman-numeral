package tdd.kata.romannumeral.validation;

import tdd.kata.romannumeral.model.InputNumber;

public class InputNumberThresholdValidator implements InputNumberValidator {

    private final int minimumThreshold;
    private final int maximumThreshold;

    public InputNumberThresholdValidator(int minimumThreshold, int maximumThreshold) {
        this.minimumThreshold = minimumThreshold;
        this.maximumThreshold = maximumThreshold;
    }

    public ValidationResult validate(final InputNumber inputNumber) {
        ValidationResult result = new ValidationResult();

        boolean isNumberWithinThreshold = inputNumber.isWithinThreshold(minimumThreshold, maximumThreshold);
        if(!isNumberWithinThreshold) {
            result.setErrorMessage(buildErrorMessage());
        }

        return result;
    }

    private String buildErrorMessage() {
        return String.format("The input number has to be between %s and %s.", minimumThreshold, maximumThreshold);
    }
}
