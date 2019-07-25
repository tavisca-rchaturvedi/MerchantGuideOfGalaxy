package com.tavisca.workshops.mgalaxy.roman.parsers;

public class QuestionToWordsAndItemNameParser implements Parser {
    public String[] parse(String query) {
        String[] parts = query.split(" is ");
        if(parts.length > 1){
            String[] words = parts[1].split(" ");
            String itemName = words[words.length -2];
            String amountInWords = "";
            for(int i = 0; i < words.length-2; i++){
                amountInWords += words[i] + " ";
            }
            return new String[]{amountInWords.trim(), itemName};
        }
        else{
            return (new UndefinedStrings()).parse(query);
        }
    }
}
