package com.tavisca.workshops.mgalaxy.roman;

public class QuestionToWordsParser implements Parser{
    public String[] parse(String query) {
        String part1 = query.split(" is ")[1];
        return new String[]{part1.substring(0,part1.length()-2).trim()};
    }
}
