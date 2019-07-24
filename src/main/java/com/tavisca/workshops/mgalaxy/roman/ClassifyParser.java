package com.tavisca.workshops.mgalaxy.roman;

public class ClassifyParser {
    public String[] findParsedOutput(String query) {
        String[] words = query.split(" ");
        String[] output;
        if(words.length == 3){
            WordsToRomanParser wordsToRomanParser = new WordsToRomanParser();
            output = wordsToRomanParser.parse(query);
            AnswerQuery.ItemToRomanValueHashMap.put(output[0],output[1]);
            return output;
        }
        else if(query.startsWith("how many")){
            QuestionToWordsAndItemNameParser questionToWordsAndItemNameParser = new QuestionToWordsAndItemNameParser();
            return questionToWordsAndItemNameParser.parse(query);
        }
        else if(query.startsWith("how much")){
            QuestionToWordsParser questionToWordsParser = new QuestionToWordsParser();
            return questionToWordsParser.parse(query);
        }
        else if(query.endsWith("Credits")){
            WordsToCreditsParser wordsToCreditsParser = new WordsToCreditsParser();
            return wordsToCreditsParser.parse(query);
        }
        else{
            return new String[]{};
        }
    }
}
