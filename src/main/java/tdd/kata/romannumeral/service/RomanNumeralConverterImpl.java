package tdd.kata.romannumeral.service;

import tdd.kata.romannumeral.model.InputNumber;
import tdd.kata.romannumeral.model.RomanNumeral;
import tdd.kata.romannumeral.model.RomanNumeralResult;

public class RomanNumeralConverterImpl implements RomanNumeralConverter {

    @Override
    public RomanNumeralResult convert(InputNumber number) {
        RomanNumeralResult result = new RomanNumeralResult();

        RemainingAmount amount = new RemainingAmount(number);
        while(amount.isGreaterThanZero()) {
            RomanNumeral numeralValue = RomanNumeral.getHighestRomanNumeral(amount.getValue());

            result.append(numeralValue);

            amount.subtract(numeralValue);
        }

        return result;
    }

    class RemainingAmount {

        private int value;

        public RemainingAmount(InputNumber number) {
            this.value = number.getValue();
        }

        public void subtract(RomanNumeral numeral) {
            this.value -= numeral.getDecimalValue();
        }

        public boolean isGreaterThanZero() {
            return value > 0;
        }

        public int getValue() {
            return value;
        }
    }
}
