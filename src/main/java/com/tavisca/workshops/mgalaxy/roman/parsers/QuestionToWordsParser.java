package com.tavisca.workshops.mgalaxy.roman.parsers;

public class QuestionToWordsParser implements Parser {
    public String[] parse(String query) {
        String[] parts = query.split(" is ");
        String part1;
        if(parts.length == 2){
            return new String[]{parts[1].substring(0,parts[1].length()-2).trim()};
        }
        else{
         return (new UndefinedStrings()).parse(query);
        }
    }
}
