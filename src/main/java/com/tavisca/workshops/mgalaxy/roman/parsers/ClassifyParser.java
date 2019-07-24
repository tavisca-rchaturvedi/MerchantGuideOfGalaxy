package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.RomanToArabic;
import com.tavisca.workshops.mgalaxy.roman.WordsToNumeralCalculation;

public class ClassifyParser {
    public String[] findParsedOutput(String query) {
        String[] words = query.split(" ");
        String[] output;
        if(words.length == 3){
            WordsToRomanParser wordsToRomanParser = new WordsToRomanParser();
            output = wordsToRomanParser.parse(query);
            WordsToNumeralCalculation.ItemToRomanValueHashMap.put(output[0],output[1]);
        }
        else if(query.startsWith("how many")){
            QuestionToWordsAndItemNameParser questionToWordsAndItemNameParser = new QuestionToWordsAndItemNameParser();
            output = questionToWordsAndItemNameParser.parse(query);
            int number = RomanToArabic.convert(WordsToNumeralCalculation.CalculateRomanNumeralFromAmountInWords(output[0]));
            int creditPerItem = WordsToNumeralCalculation.ItemToCreditValueHashmap.get(output[1]);
            int answer = number*creditPerItem;
            
            return output;
        }
        else if(query.startsWith("how much")){
            QuestionToWordsParser questionToWordsParser = new QuestionToWordsParser();
            output = questionToWordsParser.parse(query);
            int answer = RomanToArabic.convert(WordsToNumeralCalculation.CalculateRomanNumeralFromAmountInWords(output[0]));

        }
        else if(query.endsWith("Credits")){
            WordsToCreditsParser wordsToCreditsParser = new WordsToCreditsParser();
            output = wordsToCreditsParser.parse(query);
            int numberOfItems = RomanToArabic.convert(WordsToNumeralCalculation.CalculateRomanNumeralFromAmountInWords(output[0]));
            int credits = Integer.parseInt(output[2]);
            WordsToNumeralCalculation.ItemToCreditValueHashmap.put(output[1], credits/numberOfItems);
        }
        else{
            output = new String[]{};
        }
        return output;
    }
}
