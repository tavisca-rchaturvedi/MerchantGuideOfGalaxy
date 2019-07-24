package com.tavisca.workshops.mgalaxy.roman.parsers;

import com.tavisca.workshops.mgalaxy.roman.parsers.Parser;

public class QuestionToWordsParser implements Parser {
    public String[] parse(String query) {
        String part1 = query.split(" is ")[1];
        return new String[]{part1.substring(0,part1.length()-2).trim()};
    }
}
