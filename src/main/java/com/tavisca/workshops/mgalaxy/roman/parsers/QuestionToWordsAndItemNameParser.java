package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.CalculateCredits;
import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;

public class QuestionToWordsAndItemNameParser implements Parser {
    public String[] parse(String query) {
        String[] parts = query.split(" is ");
        if(parts.length > 1){
            String[] words = parts[1].split(" ");
            String amountInWords = "";
            for(int i = 0; i < words.length-2; i++){
                amountInWords += words[i] + " ";
            }
            return new String[]{amountInWords.trim(), words[words.length -2]};
        }
        else{
            return (new UndefinedStrings()).parse(query);
        }
    }

    public String process(String query, String[] outputs, RomanNumeralCalculator romanNumeralCalculator){
        String[] stringsOfInterest = outputs;
        CalculateCredits calculateCredits = new CalculateCredits();
        double creditValue = calculateCredits.calculateCredit(stringsOfInterest,romanNumeralCalculator);
        return stringsOfInterest[0] +  " " + stringsOfInterest[1] + " is " + getCreditValue(creditValue) + " Credits";

    }

    public String getCreditValue(double creditValue){
        String creditValueInString;
        if(creditValue == (int) creditValue) creditValueInString = (int)creditValue + "";
        else creditValueInString = creditValue + "";

        return creditValueInString;
    }
}
