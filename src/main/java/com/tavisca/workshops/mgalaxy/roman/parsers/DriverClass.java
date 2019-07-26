package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.CalculateCredits;
import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;
import com.tavisca.workshops.mgalaxy.roman.RomanToArabic;

import java.util.HashMap;

public class DriverClass {

    public HashMap<String, String> queryToAnswer = new HashMap<>();

    public void processSentenceAndStoreAnswers(String query, RomanNumeralCalculator romanNumeralCalculator) {
        CalculateCredits calculateCredits = new CalculateCredits();
        String[] stringsOfInterest;
        Parser parser;
        if(query.split(" ").length == 3){
            parser = new WordsToRomanParser();
            romanNumeralCalculator.storeItemToRomanValue(parser.parse(query));
        }
        else if(query.startsWith("how many")){
            parser = new QuestionToWordsAndItemNameParser();
            stringsOfInterest = parser.parse(query);
            double creditValue = calculateCredits.calculateCredit(stringsOfInterest,romanNumeralCalculator);
            String credtValueInString;
            if(creditValue == (int) creditValue) credtValueInString = (int)creditValue + "";
            else credtValueInString = creditValue + "";
            this.queryToAnswer.put(query,stringsOfInterest[0] +  " " + stringsOfInterest[1] + " is " + credtValueInString + " Credits");
        }
        else if(query.startsWith("how much")){
            parser = new QuestionToWordsParser();
            stringsOfInterest = parser.parse(query);
            String romanNumeral = romanNumeralCalculator.calculateRomanNumeralFromAmountInWords(stringsOfInterest[0]);
            System.out.println(romanNumeral);
            if(romanNumeral.length() > 0)
                this.queryToAnswer.put(query,stringsOfInterest[0] + " is " +RomanToArabic.convert(romanNumeral));
            else
                this.queryToAnswer.put(query,(new UndefinedStrings()).parse(query)[0]);
        }
        else if(query.endsWith("Credits")){
            parser = new WordsToCreditsParser();
            calculateCredits = new CalculateCredits();
            calculateCredits.calculateCreditPerItem(parser.parse(query), romanNumeralCalculator);
        }
        else{
            parser = new UndefinedStrings();
            stringsOfInterest = parser.parse(query);
            this.queryToAnswer.put(query, stringsOfInterest[0]);
        }
        //return parser.parse(query);
    }

   public String getQueryToAnswer(String query){
        return this.queryToAnswer.get(query);
    }
}