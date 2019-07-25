package com.tavisca.workshops.mgalaxy.roman;

import java.util.HashMap;

public class RomanToArabic {

    public static HashMap<Character, Integer> romanToArabicValuesHashMap = new HashMap<Character, Integer>() {{
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
        System.out.println(roman);
        for(int i = 0; i < roman.length()-1; i++){
            if(romanToArabicValuesHashMap.get(roman.charAt(i)) < romanToArabicValuesHashMap.get(roman.charAt(i+1))){
                sum -= romanToArabicValuesHashMap.get(roman.charAt(i));
            }
            else{
                sum += romanToArabicValuesHashMap.get(roman.charAt(i));
            }
        }

        sum += romanToArabicValuesHashMap.get(roman.charAt(roman.length()-1));

        return sum;
    }
}

