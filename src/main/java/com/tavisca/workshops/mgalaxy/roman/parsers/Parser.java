package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculation;

public interface Parser {
    public RomanNumeralCalculation romanNumeralCalculation = new RomanNumeralCalculation();
    public String[] parse(String query);
}
