package com.tavisca.workshops.mgalaxy.roman.parsers;


import com.tavisca.workshops.mgalaxy.roman.WordsToNumeralCalculation;

public class WordsToRomanParser implements Parser {

    public String[] parse(String query) {
        String[] words = query.split(" ");
        WordsToNumeralCalculation wordsToNumeralCalculation = new WordsToNumeralCalculation();
        String[] output = new String[] {words[0], words[2]};
        wordsToNumeralCalculation.StoreItemToRomanValue(output);
        return output;
    }
}


