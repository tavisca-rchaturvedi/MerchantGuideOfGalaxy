package com.tavisca.workshops.mgalaxy.roman;

public class ClassifyParser {
    public String[] findParsedOutput(String query) {
        String[] words = query.split(" ");

        if(words.length == 3){
            WordsToRomanParser wordsToRomanParser = new WordsToRomanParser();
            return wordsToRomanParser.parse(query);
        }
        else if(query.startsWith("how many")){
            QuestionToWordsAndItemNameParser questionToWordsAndItemNameParser = new QuestionToWordsAndItemNameParser();
            return questionToWordsAndItemNameParser.parse(query);
        }
        else if(query.startsWith("how much")){
            QuestionToWordsParser questionToWordsParser = new QuestionToWordsParser();
            return questionToWordsParser.parse(query);
        }
        else{
            WordsToCreditsParser wordsToCreditsParser = new WordsToCreditsParser();
            return wordsToCreditsParser.parse(query);
        }
    }
}
