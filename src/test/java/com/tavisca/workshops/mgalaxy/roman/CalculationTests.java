package com.tavisca.workshops.mgalaxy.roman;

import com.tavisca.workshops.mgalaxy.roman.parsers.ClassifyParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationTests {
    RomanNumeralCalculation romanCalculate;

    @BeforeEach
    void beforeEachTest(){
        romanCalculate = new RomanNumeralCalculation();
    }

    @Test
    void AmountInWordsToRomanNumeralCalculation(){
        ClassifyParser classifyParser = new ClassifyParser();

        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("tegj is L"));

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
        ClassifyParser classifyParser = new ClassifyParser();
        CalculateCredits calculate = new CalculateCredits();

        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("tegj is L"));

        calculate.CalculateCreditPerItem(classifyParser.processSentence("glob glob Silver is 34 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyParser.processSentence("glob prok Gold is 57800 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyParser.processSentence("pish pish Iron is 3910 Credits"), romanCalculate);

        String[] StringsOfInterest = classifyParser.processSentence("how many Credits is glob prok Silver ? ");

        assertEquals(68, calculate.CalculateCredit(StringsOfInterest, romanCalculate));
    }

    @Test
    void WordsToArabicNumeralCalculation(){
        ClassifyParser classifyParser = new ClassifyParser();
        RomanToArabic romanToArabic = new RomanToArabic();


        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("tegj is L"));

        String[] stringOfInterest = classifyParser.processSentence("how much is pish tegj glob glob ? ");
        String romanNumeral = romanCalculate.CalculateRomanNumeralFromAmountInWords(stringOfInterest[0]);
        assertEquals(42, romanToArabic.convert(romanNumeral));
    }

    @Test
    void AllGivenTestCasesWorking(){
        ClassifyParser classifyParser = new ClassifyParser();
        CalculateCredits calculate = new CalculateCredits();

        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("tegj is L"));

        calculate.CalculateCreditPerItem(classifyParser.processSentence("glob glob Silver is 34 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyParser.processSentence("glob prok Gold is 57800 Credits"), romanCalculate);
        calculate.CalculateCreditPerItem(classifyParser.processSentence("pish pish Iron is 3910 Credits"), romanCalculate);

        String[] stringOfInterest = classifyParser.processSentence("how much is pish tegj glob glob ? ");
        String romanNumeral = romanCalculate.CalculateRomanNumeralFromAmountInWords(stringOfInterest[0]);
        assertEquals(42, RomanToArabic.convert(romanNumeral));

        stringOfInterest = classifyParser.processSentence("how many Credits is glob prok Silver ? ");
        assertEquals(68, calculate.CalculateCredit(stringOfInterest, romanCalculate));

        stringOfInterest = classifyParser.processSentence("how many Credits is glob prok Gold ? ");
        assertEquals(57800, calculate.CalculateCredit(stringOfInterest, romanCalculate));

        stringOfInterest = classifyParser.processSentence("how many Credits is glob prok Iron ? ");
        assertEquals(782, calculate.CalculateCredit(stringOfInterest, romanCalculate));

        stringOfInterest = classifyParser.processSentence("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        assertEquals("I have no idea what you are talking about", stringOfInterest[0]);

    }
}
