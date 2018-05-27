package tdd.kata.romannumeral.service;

import tdd.kata.romannumeral.model.InputNumber;
import tdd.kata.romannumeral.model.RomanNumeralResult;

public interface RomanNumeralConverter {

    RomanNumeralResult convert(InputNumber number);

}
