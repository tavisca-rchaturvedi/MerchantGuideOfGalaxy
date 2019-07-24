package com.tavisca.workshops.mgalaxy.roman;

public class QuestionToWordsAndItemNameParser implements Parser {
    public String[] parse(String query) {
        String part1 = query.split(" is ")[1];
        String[] words = part1.split(" ");
        String itemName = words[words.length -2];
        String amountInWords = "";
        for(int i = 0; i < words.length-2; i++){
            amountInWords += words[i] + " ";
        }
        return new String[]{amountInWords.trim(), itemName};
    }
}
