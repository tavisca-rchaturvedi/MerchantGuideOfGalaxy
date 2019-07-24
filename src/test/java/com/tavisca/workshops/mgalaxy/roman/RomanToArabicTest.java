package com.tavisca.workshops.mgalaxy.roman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RomanToArabicTest {

    @Test
    void RomanStringToArabicNumeralConversion(){
        String[] RomanStrings = new String[]{"VI", "XII", "XIX"};
        int[] ArabicNumeral = new int[RomanStrings.length];
        int i =0;
        for(String roman : RomanStrings){
             ArabicNumeral[i++] = RomanToArabic.convert(roman);
        }

        assertArrayEquals(new int[]{6,12,19},ArabicNumeral);
    }



}
