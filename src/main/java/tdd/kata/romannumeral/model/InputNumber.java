package tdd.kata.romannumeral.model;

public final class InputNumber {

    private final int value;

    public InputNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEqualOrLowerThan(final int threshold) {
        return value <= threshold;
    }

    public boolean isEqualOrGreaterThan(final int threshold) {
        return value >= threshold;
    }

    public boolean isWithinThreshold(final int minimumThreshold, final int maximumThreshold) {
        boolean isNumberAboveMinThreshold = isEqualOrGreaterThan(minimumThreshold);
        boolean isNumberBelowMaxThreshold = isEqualOrLowerThan(maximumThreshold);

        return isNumberAboveMinThreshold && isNumberBelowMaxThreshold;
    }
}
