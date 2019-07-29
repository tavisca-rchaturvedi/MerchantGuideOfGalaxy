package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;
import com.tavisca.workshops.mgalaxy.roman.RomanToArabic;

public class QuestionToWordsParser implements Parser {
    public String[] parse(String query) {
        String[] parts = query.split(" is ");
        if(parts.length == 2){
            return new String[]{parts[1].substring(0,parts[1].length()-2).trim()};
        }
        else{
            return (new UndefinedStrings()).parse(query);
        }
    }

    public String process(String query, String[] outputs, RomanNumeralCalculator romanNumeralCalculator){
        String romanNumeral = romanNumeralCalculator.calculateRomanNumeralFromAmountInWords(outputs[0]);
        if(romanNumeral.length() > 0)
            return outputs[0] + " is " + RomanToArabic.convert(romanNumeral);
        else
            return (new UndefinedStrings()).parse(query)[0];
    }
}
