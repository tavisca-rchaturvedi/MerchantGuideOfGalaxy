package com.tavisca.workshops.mgalaxy.roman;
import java.util.HashMap;

public class RomanToArabic {

    public static HashMap<Character, Integer> romanValues = new HashMap<Character, Integer>() {{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};

    public static int convert(String roman) {
        int sum = 0;
        for(char numeral: roman.toCharArray()){
            sum += romanValues.get(numeral);
        }
        return sum;
    }
}

