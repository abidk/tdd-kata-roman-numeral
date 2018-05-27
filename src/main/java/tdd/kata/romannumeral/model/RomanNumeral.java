package tdd.kata.romannumeral.model;

public enum RomanNumeral {
    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    private final int decimalValue;

    RomanNumeral(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    public static RomanNumeral getHighestRomanNumeral(int number) {
        for (RomanNumeral numeral : RomanNumeral.values()) {
            boolean isNumberGreaterThanRomanNumeralDecimal = number >= numeral.getDecimalValue();

            if(isNumberGreaterThanRomanNumeralDecimal) {
                return numeral;
            }
        }
        return null;
    }
}