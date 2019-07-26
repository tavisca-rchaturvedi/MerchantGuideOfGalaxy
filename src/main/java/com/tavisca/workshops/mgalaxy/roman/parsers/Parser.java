package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;

public interface Parser {
    public RomanNumeralCalculator romanNumeralCalculation = new RomanNumeralCalculator();
    public String[] parse(String query);
}
