package com.tavisca.workshops.mgalaxy.roman.parsers;


public class WordsToRomanParser implements Parser {

    public String[] parse(String query) {
        String[] words = query.split(" ");
        String[] output = new String[] {words[0], words[2]};
        return output;
    }
}


