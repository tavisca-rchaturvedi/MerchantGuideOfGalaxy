package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.RomanToArabic;
import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculation;

public class ClassifyParser {
    public String[] findParsedOutput(String query) {
        String[] words = query.split(" ");
        String[] output;
        if(words.length == 3){
            WordsToRomanParser wordsToRomanParser = new WordsToRomanParser();
            output = wordsToRomanParser.parse(query);
            RomanNumeralCalculation.ItemToRomanValueHashMap.put(output[0],output[1]);
        }
        else if(query.startsWith("how many")){
            QuestionToWordsAndItemNameParser questionToWordsAndItemNameParser = new QuestionToWordsAndItemNameParser();
            output = questionToWordsAndItemNameParser.parse(query);
        }
        else if(query.startsWith("how much")){
            QuestionToWordsParser questionToWordsParser = new QuestionToWordsParser();
            output = questionToWordsParser.parse(query);

        }
        else if(query.endsWith("Credits")){
            WordsToCreditsParser wordsToCreditsParser = new WordsToCreditsParser();
            output = wordsToCreditsParser.parse(query);
            double numberOfItems = RomanToArabic.convert(RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords(output[0]));
            double credits = Integer.parseInt(output[2]);
            RomanNumeralCalculation.ItemToCreditValueHashmap.put(output[1], credits/numberOfItems);
        }
        else{
            output = new String[]{};
        }
        return output;
    }
}
