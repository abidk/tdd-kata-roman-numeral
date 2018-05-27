package tdd.kata.romannumeral.validation;

import tdd.kata.romannumeral.model.InputNumber;

public interface InputNumberValidator {

    ValidationResult validate(InputNumber inputNumber);

}
