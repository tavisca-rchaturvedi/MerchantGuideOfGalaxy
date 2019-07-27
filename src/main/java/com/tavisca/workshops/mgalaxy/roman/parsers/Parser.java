package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;

public interface Parser {
    public String[] parse(String query);
    public String process(String query, String[] output, RomanNumeralCalculator romanNumeralCalculator);
}
