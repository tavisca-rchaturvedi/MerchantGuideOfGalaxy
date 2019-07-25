package com.tavisca.workshops.mgalaxy.roman.parsers;


public class ClassifyParser {
    public String[] findParsedOutput(String query) {
        String[] words = query.split(" ");
        String[] output;
        if(words.length == 3){
            WordsToRomanParser wordsToRomanParser = new WordsToRomanParser();
            output = wordsToRomanParser.parse(query);
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
        }
        else{
            output = new String[]{};
        }
        return output;
    }
}
