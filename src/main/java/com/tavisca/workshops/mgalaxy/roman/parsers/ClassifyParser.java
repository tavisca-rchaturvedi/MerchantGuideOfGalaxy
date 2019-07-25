package com.tavisca.workshops.mgalaxy.roman.parsers;

public class ClassifyParser {
    public String[] processSentence(String query) {
        Parser parser;
        if(query.split(" ").length == 3){
            parser = new WordsToRomanParser();
        }
        else if(query.startsWith("how many")){
            parser = new QuestionToWordsAndItemNameParser();
        }
        else if(query.startsWith("how much")){
            parser = new QuestionToWordsParser();
        }
        else if(query.endsWith("Credits")){
            parser = new WordsToCreditsParser();
        }
        else{
            parser = new UndefinedStrings();
        }
        return parser.parse(query);
    }
}
