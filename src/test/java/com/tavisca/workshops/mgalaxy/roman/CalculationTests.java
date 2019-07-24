package com.tavisca.workshops.mgalaxy.roman;

import com.tavisca.workshops.mgalaxy.roman.parsers.ClassifyParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationTests {
    @Test
    void AmountInWordsToRomanNumeralCalculation(){
        ClassifyParser classifyParser = new ClassifyParser();
        classifyParser.findParsedOutput("glob is I");
        classifyParser.findParsedOutput("prok is V");
        classifyParser.findParsedOutput("pish is X");
        classifyParser.findParsedOutput("tegj is L");

        assertEquals("II", WordsToNumeralCalculation.CalculateRomanNumeralFromAmountInWords("glob glob"));
        assertEquals("IV", WordsToNumeralCalculation.CalculateRomanNumeralFromAmountInWords("glob prok"));
        assertEquals("XX", WordsToNumeralCalculation.CalculateRomanNumeralFromAmountInWords("pish pish"));
    }

    @Test
    void isValidRomanNumeral(){

    }

    @Test
    void RomanToArabicNumeralCalculation(){
        assertEquals(2,RomanToArabic.convert("II"));
    }
}
