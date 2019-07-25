package com.tavisca.workshops.mgalaxy.roman;

import com.tavisca.workshops.mgalaxy.roman.parsers.ClassifyParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationTests {



    @Test
    void AmountInWordsToRomanNumeralCalculation(){
        ClassifyParser classifyParser = new ClassifyParser();
        RomanNumeralCalculation romanCalculate = new RomanNumeralCalculation();

        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("tegj is L"));

        assertEquals("II", RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords("glob glob"));
        assertEquals("IV", RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords("glob prok"));
        assertEquals("XX", RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords("pish pish"));
    }

    @Test
    void isValidRomanNumeral(){

    }

    @Test
    void RomanToArabicNumeralCalculation(){
        assertEquals(2,RomanToArabic.convert("II"));
    }

    @Test
    void CreditCalculatedByItemNameAndCreditPerItem(){
        ClassifyParser classifyParser = new ClassifyParser();
        CalculateCredits calculate = new CalculateCredits();
        RomanNumeralCalculation romanCalculate = new RomanNumeralCalculation();

        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("tegj is L"));

        calculate.CalculateCreditPerItem(classifyParser.findParsedOutput("glob glob Silver is 34 Credits"));
        calculate.CalculateCreditPerItem(classifyParser.findParsedOutput("glob prok Gold is 57800 Credits"));
        calculate.CalculateCreditPerItem(classifyParser.findParsedOutput("pish pish Iron is 3910 Credits"));

        String[] StringsOfInterest = classifyParser.findParsedOutput("how many Credits is glob prok Silver ? ");

        assertEquals(68, calculate.CalculateCredit(StringsOfInterest));
    }

    @Test
    void WordsToArabicNumeralCalculation(){
        ClassifyParser classifyParser = new ClassifyParser();
        RomanNumeralCalculation romanCalculate = new RomanNumeralCalculation();


        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("tegj is L"));

        String[] stringOfInterest = classifyParser.findParsedOutput("how much is pish tegj glob glob ? ");
        String romanNumeral = RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords(stringOfInterest[0]);
        assertEquals(42, RomanToArabic.convert(romanNumeral));
    }

    @Test
    void AllGivenTestCasesWorking(){
        ClassifyParser classifyParser = new ClassifyParser();
        CalculateCredits calculate = new CalculateCredits();
        RomanNumeralCalculation romanCalculate = new RomanNumeralCalculation();

        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("glob is I"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("prok is V"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("pish is X"));
        romanCalculate.StoreItemToRomanValue(classifyParser.findParsedOutput("tegj is L"));


        calculate.CalculateCreditPerItem(classifyParser.findParsedOutput("glob glob Silver is 34 Credits"));
        calculate.CalculateCreditPerItem(classifyParser.findParsedOutput("glob prok Gold is 57800 Credits"));
        calculate.CalculateCreditPerItem(classifyParser.findParsedOutput("pish pish Iron is 3910 Credits"));


        String[] stringOfInterest = classifyParser.findParsedOutput("how much is pish tegj glob glob ? ");
        String romanNumeral = RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords(stringOfInterest[0]);
        assertEquals(42, RomanToArabic.convert(romanNumeral));

        stringOfInterest = classifyParser.findParsedOutput("how many Credits is glob prok Silver ? ");
        assertEquals(68, calculate.CalculateCredit(stringOfInterest));

        stringOfInterest = classifyParser.findParsedOutput("how many Credits is glob prok Gold ? ");
        assertEquals(57800, calculate.CalculateCredit(stringOfInterest));

        stringOfInterest = classifyParser.findParsedOutput("how many Credits is glob prok Iron ? ");
        assertEquals(782, calculate.CalculateCredit(stringOfInterest));

    }
}
