package com.tavisca.workshops.mgalaxy.roman;
import java.util.HashMap;


public class WordToRomanParser {

    public String[] parse(String query) {
        String[] words = query.split(" ");
        return new String[] {words[0], words[2]};
    }
}
