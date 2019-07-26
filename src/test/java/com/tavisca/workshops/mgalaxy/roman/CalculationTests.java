package com.tavisca.workshops.mgalaxy.roman;

import com.tavisca.workshops.mgalaxy.roman.parsers.ClassifyingParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationTests {
    RomanNumeralCalculator romanCalculate;

    @BeforeEach
    void beforeEachTest(){
        romanCalculate = new RomanNumeralCalculator();
    }

    @Test
    void AmountInWordsToRomanNumeralCalculation(){
        ClassifyingParser classifyingParser = new ClassifyingParser();

        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("glob is I"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("prok is V"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("pish is X"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("tegj is L"));

        assertEquals("II", romanCalculate.CalculateRomanNumeralFromAmountInWords("glob glob"));
        assertEquals("IV", romanCalculate.CalculateRomanNumeralFromAmountInWords("glob prok"));
        assertEquals("XX", romanCalculate.CalculateRomanNumeralFromAmountInWords("pish pish"));
    }


    @Test
    void RomanToArabicNumeralCalculation(){
        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(2,romanToArabic.convert("II"));
    }

    @Test
    void CreditCalculatedByItemNameAndCreditPerItem(){
        ClassifyingParser classifyingParser = new ClassifyingParser();
        CalculateCredits calculate = new CalculateCredits();

        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("glob is I"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("prok is V"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("pish is X"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("tegj is L"));

        calculate.CalculateCreditPerItem(classifyingParser.processSentence("glob glob Silver is 34 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyingParser.processSentence("glob prok Gold is 57800 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyingParser.processSentence("pish pish Iron is 3910 Credits"), romanCalculate);

        String[] StringsOfInterest = classifyingParser.processSentence("how many Credits is glob prok Silver ? ");

        assertEquals(68, calculate.CalculateCredit(StringsOfInterest, romanCalculate));
    }

    @Test
    void WordsToArabicNumeralCalculation(){
        ClassifyingParser classifyingParser = new ClassifyingParser();
        RomanToArabic romanToArabic = new RomanToArabic();

        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("glob is I"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("prok is V"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("pish is X"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("tegj is L"));

        String[] stringOfInterest = classifyingParser.processSentence("how much is pish tegj glob glob ? ");
        String romanNumeral = romanCalculate.CalculateRomanNumeralFromAmountInWords(stringOfInterest[0]);
        assertEquals(42, romanToArabic.convert(romanNumeral));
    }


    @Test
    void AllGivenTestCasesWorking(){
        ClassifyingParser classifyingParser = new ClassifyingParser();
        CalculateCredits calculate = new CalculateCredits();

        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("glob is I"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("prok is V"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("pish is X"));
        romanCalculate.storeItemToRomanValue(classifyingParser.processSentence("tegj is L"));

        calculate.CalculateCreditPerItem(classifyingParser.processSentence("glob glob Silver is 34 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyingParser.processSentence("glob prok Gold is 57800 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyingParser.processSentence("pish pish Iron is 3910 Credits"), romanCalculate);

        String[] stringOfInterest = classifyingParser.processSentence("how much is pish tegj glob glob ? ");
        String romanNumeral = romanCalculate.CalculateRomanNumeralFromAmountInWords(stringOfInterest[0]);
        assertEquals(42, RomanToArabic.convert(romanNumeral));

        stringOfInterest = classifyingParser.processSentence("how many Credits is glob prok Silver ? ");
        assertEquals(68, calculate.CalculateCredit(stringOfInterest, romanCalculate));

        stringOfInterest = classifyingParser.processSentence("how many Credits is glob prok Gold ? ");
        assertEquals(57800, calculate.CalculateCredit(stringOfInterest, romanCalculate));

        stringOfInterest = classifyingParser.processSentence("how many Credits is glob prok Iron ? ");
        assertEquals(782, calculate.CalculateCredit(stringOfInterest, romanCalculate));

        stringOfInterest = classifyingParser.processSentence("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        assertArrayEquals(new String[]{"I have no idea what you are talking about"}, stringOfInterest);

    }
}
