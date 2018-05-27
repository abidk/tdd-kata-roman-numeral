package tdd.kata.romannumeral.model;

import java.util.ArrayList;
import java.util.List;

public final class RomanNumeralResult {

    private final List<RomanNumeral> values = new ArrayList<>();

    public void append(RomanNumeral numeral) {
        values.add(numeral);
    }

    public String getTextValue() {
        StringBuilder text = new StringBuilder();

        for(RomanNumeral value : values) {
            text.append(value.name());
        }

        return text.toString();
    }

    @Override
    public String toString() {
        return getTextValue();
    }
}
