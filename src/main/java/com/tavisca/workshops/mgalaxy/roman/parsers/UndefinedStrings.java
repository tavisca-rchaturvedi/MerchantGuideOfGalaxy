package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;

public class UndefinedStrings implements Parser {
    public String[] parse(String query){
        return new String[]{"I have no idea what you are talking about"};
    }
    public String process(String query, String[] outputs, RomanNumeralCalculator romanNumeralCalculator){ return "";}
}
