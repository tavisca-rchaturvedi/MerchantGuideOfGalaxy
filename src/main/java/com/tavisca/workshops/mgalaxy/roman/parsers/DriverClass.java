package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.CalculateCredits;
import com.tavisca.workshops.mgalaxy.roman.RomanNumeralCalculator;

import java.util.HashMap;

public class DriverClass {

    public HashMap<String, String> queryToAnswer = new HashMap<>();

    public void processSentenceAndStoreAnswers(String query, RomanNumeralCalculator romanNumeralCalculator) {
        Parser parser;

        if(query.split(" ").length == 3){
            parser = new WordsToRomanParser();
            parser.process(query, parser.parse(query), romanNumeralCalculator);
        }
        else if(query.startsWith("how many")){
            parser = new QuestionToWordsAndItemNameParser();
            this.putQueryToAnswer(query, parser.process(query, parser.parse(query), romanNumeralCalculator));
        }
        else if(query.startsWith("how much is ")){
            parser = new QuestionToWordsParser();
            this.putQueryToAnswer(query, parser.process(query, parser.parse(query), romanNumeralCalculator));
        }
        else if(query.endsWith("Credits")){
            parser = new WordsToCreditsParser();
            parser.process(query, parser.parse(query), romanNumeralCalculator);
        }
        else{
            this.putQueryToAnswer(query, "I have no idea what you are talking about");
        }
    }



    public String getQueryToAnswer(String query){
        return this.queryToAnswer.get(query);
    }
    public void putQueryToAnswer(String query, String answer) { this.queryToAnswer.put(query, answer);}
}
