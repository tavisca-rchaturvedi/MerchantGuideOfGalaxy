package com.tavisca.workshops.mgalaxy.roman;


public class WordsToRomanParser implements Parser {

    public String[] parse(String query) {
        String[] words = query.split(" ");
        AnswerQuery answerQuery = new AnswerQuery();
        String[] output = new String[] {words[0], words[2]};
        answerQuery.StoreItemToRomanValue(output);
        return output;
    }
}
