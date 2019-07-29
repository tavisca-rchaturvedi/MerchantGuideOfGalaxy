package com.tavisca.workshops.mgalaxy.roman.parsers;


import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;

public class WordsToRomanParser implements Parser {

    public String[] parse(String query) {
        String[] words = query.split(" ");
        String[] output = new String[] {words[0], words[2]};
        return output;
    }

    public String process(String query, String[] outputs, RomanNumeralCalculator romanNumeralCalculator){
        romanNumeralCalculator.storeItemToRomanValue(outputs);
        return "";
    }
}


