package tdd.kata.romannumeral;

import tdd.kata.romannumeral.model.InputNumber;
import tdd.kata.romannumeral.model.RomanNumeralResult;
import tdd.kata.romannumeral.service.RomanNumeralConverter;
import tdd.kata.romannumeral.validation.InputNumberValidationException;
import tdd.kata.romannumeral.validation.InputNumberValidator;
import tdd.kata.romannumeral.validation.ValidationResult;

public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

    private final InputNumberValidator numberValidator;
    private final RomanNumeralConverter numeralConverter;

    public RomanNumeralGeneratorImpl(InputNumberValidator numberValidator, RomanNumeralConverter numeralConverter) {
        this.numberValidator = numberValidator;
        this.numeralConverter = numeralConverter;
    }

    /**
     * Please note i'm using the defined interface. Otherwise it's better to
     * avoid 'primitive obsession' and pass in InputNumber and return a Result object.
     */
    public String generate(int number) {
        final InputNumber inputNumber = new InputNumber(number);

        validateInputNumber(inputNumber);

        return convertToRomanNumeralValue(inputNumber);
    }

    private String convertToRomanNumeralValue(InputNumber inputNumber) {
        RomanNumeralResult result = numeralConverter.convert(inputNumber);
        return result.toString();
    }

    private void validateInputNumber(InputNumber inputNumber) {
        ValidationResult result = numberValidator.validate(inputNumber);
        if(result.hasError()) {
            throw new InputNumberValidationException(result.getErrorMessage());
        }
    }

}
