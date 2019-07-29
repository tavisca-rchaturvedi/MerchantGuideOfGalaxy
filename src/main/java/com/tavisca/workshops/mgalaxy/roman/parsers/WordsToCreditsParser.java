package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.CalculateCredits;
import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;

public class WordsToCreditsParser implements Parser {
    public String[] parse(String query)  {
        String[] words = query.split(" is ");
        String[] firstPart = words[0].split(" ");

        String itemName = firstPart[firstPart.length-1];
        String amountInWords = "";

        for(int i =0; i < firstPart.length - 1; i++){
            amountInWords += firstPart[i] + " ";
        }
        String number = words[1].split(" ")[0];
        return new String[]{amountInWords.trim(), itemName, number};
    }

    public String process(String query, String[] outputs, RomanNumeralCalculator romanNumeralCalculator){
        (new CalculateCredits()).calculateAndStoreCreditPerItem(outputs, romanNumeralCalculator);
        return "";
    }
}
