package com.tavisca.workshops.mgalaxy.roman.parsers;


import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculation;

public class WordsToRomanParser implements Parser {

    public String[] parse(String query) {
        String[] words = query.split(" ");
        RomanNumeralCalculation romanNumeralCalculation = new RomanNumeralCalculation();
        String[] output = new String[] {words[0], words[2]};
        romanNumeralCalculation.StoreItemToRomanValue(output);
        return output;
    }
}


