package com.tavisca.workshops.mgalaxy.roman.parsers;

public class UndefinedStrings implements Parser {
    public String[] parse(String query){
        return new String[]{"I have no idea what you are talking about"};
    }
}
