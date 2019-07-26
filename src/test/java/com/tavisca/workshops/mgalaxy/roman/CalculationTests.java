package com.tavisca.workshops.mgalaxy.roman;

import com.tavisca.workshops.mgalaxy.roman.parsers.DriverClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationTests {
    RomanNumeralCalculator romanCalculate;
    DriverClass driverClass;
    CalculateCredits calculate;
    String query;

    @BeforeEach
    void beforeEachTest(){
        romanCalculate = new RomanNumeralCalculator();
        driverClass = new DriverClass();
        calculate = new CalculateCredits();
    }

    void initializeFirstStatements(){
        driverClass.processSentenceAndStoreAnswers("glob is I", romanCalculate);
        driverClass.processSentenceAndStoreAnswers("prok is V", romanCalculate);
        driverClass.processSentenceAndStoreAnswers("pish is X", romanCalculate);
        driverClass.processSentenceAndStoreAnswers("tegj is L", romanCalculate);
    }

    void initializeSecondStatements(){
        driverClass.processSentenceAndStoreAnswers("glob glob Silver is 34 Credits", romanCalculate);
        driverClass.processSentenceAndStoreAnswers("glob prok Gold is 57800 Credits", romanCalculate);
        driverClass.processSentenceAndStoreAnswers("pish pish Iron is 3910 Credits", romanCalculate);
    }


    @Test
    void amountInWordsToRomanNumeralCalculation(){
        initializeFirstStatements();

        assertEquals("II", romanCalculate.calculateRomanNumeralFromAmountInWords("glob glob"));
        assertEquals("IV", romanCalculate.calculateRomanNumeralFromAmountInWords("glob prok"));
        assertEquals("XX", romanCalculate.calculateRomanNumeralFromAmountInWords("pish pish"));
    }


    @Test
    void romanToArabicNumeralCalculation(){
        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(2,romanToArabic.convert("II"));
    }

    @Test
    void creditCalculatedByItemNameAndCreditPerItem(){

        initializeFirstStatements();
        initializeSecondStatements();
        query = "how many Credits is glob prok Silver ? ";

        driverClass.processSentenceAndStoreAnswers(query, romanCalculate);
        assertEquals("glob prok Silver is 68 Credits", driverClass.getQueryToAnswer(query));
    }

    @Test
    void wordsToArabicNumeralCalculation(){
        RomanToArabic romanToArabic = new RomanToArabic();

        initializeFirstStatements();
        query = "how much is pish tegj glob glob ? ";

        driverClass.processSentenceAndStoreAnswers(query, romanCalculate);
        assertEquals("pish tegj glob glob is 42", driverClass.getQueryToAnswer(query));
    }


    @Test
    void allGivenTestCasesWorking(){

        initializeFirstStatements();
        initializeSecondStatements();

        query = "how much is pish tegj glob glob ? ";
        driverClass.processSentenceAndStoreAnswers(query, romanCalculate);
        assertEquals("pish tegj glob glob is 42", driverClass.getQueryToAnswer(query));

        query = "how many Credits is glob prok Silver ? ";
        driverClass.processSentenceAndStoreAnswers(query, romanCalculate);
        assertEquals("glob prok Silver is 68 Credits", driverClass.getQueryToAnswer(query));

        query = "how many Credits is glob prok Gold ? ";
        driverClass.processSentenceAndStoreAnswers(query, romanCalculate);
        assertEquals("glob prok Gold is 57800 Credits", driverClass.getQueryToAnswer(query));

        query = "how many Credits is glob prok Iron ? ";
        driverClass.processSentenceAndStoreAnswers(query, romanCalculate);
        assertEquals("glob prok Iron is 782 Credits", driverClass.getQueryToAnswer(query));

        query = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
        driverClass.processSentenceAndStoreAnswers(query, romanCalculate);
        assertEquals("I have no idea what you are talking about", driverClass.getQueryToAnswer(query));

    }
}
