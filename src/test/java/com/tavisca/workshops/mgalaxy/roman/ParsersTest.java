package com.tavisca.workshops.mgalaxy.roman;

import com.tavisca.workshops.mgalaxy.roman.parsers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ParsersTest {

    RomanNumeralCalculation romanCalculate;

    @BeforeEach
    void beforeEachTest(){
        romanCalculate = new RomanNumeralCalculation();
    }

    @Test
    void canParseWordToRomanNumeralStatement(){
        WordsToRomanParser wordsToRomanParser = new WordsToRomanParser();
        assertArrayEquals(new String[]{"glob","I"}, wordsToRomanParser.parse("glob is I"));
        assertArrayEquals(new String[]{"prok","V"}, wordsToRomanParser.parse("prok is V"));
        assertArrayEquals(new String[]{"pish","X"}, wordsToRomanParser.parse("pish is X"));
        assertArrayEquals(new String[]{"tegj","L"}, wordsToRomanParser.parse("tegj is L"));
    }

    @Test
    void canParseCreditCalculationStatement(){
        WordsToCreditsParser wordsToCreditsParser = new WordsToCreditsParser();
        assertArrayEquals(new String[]{"glob glob","Silver","34"}, wordsToCreditsParser.parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"glob prok","Gold","57800"}, wordsToCreditsParser.parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"pish pish","Iron","3910"}, wordsToCreditsParser.parse("pish pish Iron is 3910 Credits"));
    }


    @Test
    void canAnswerCreditFindingQuestions(){
        QuestionToWordsAndItemNameParser parser = new QuestionToWordsAndItemNameParser();
        assertArrayEquals(new String[]{"glob prok","Silver"}, parser.parse("how many Credits is glob prok Silver ? "));
        assertArrayEquals(new String[]{"glob prok","Gold"}, parser.parse("how many Credits is glob prok Gold ? "));
        assertArrayEquals(new String[]{"glob prok","Iron"}, parser.parse("how many Credits is glob prok Iron ? "));
    }

    @Test
    void canParseHowMuchTypeQuestions(){
        QuestionToWordsParser parser = new QuestionToWordsParser();
        assertArrayEquals(new String[]{"pish tegj glob glob"}, parser.parse("how much is pish tegj glob glob ? "));
    }

    @Test
    void wordsCorrectlyClassifiedToParsers(){
        ClassifyParser classifyParser = new ClassifyParser();
        assertArrayEquals(new String[]{"glob glob","Silver","34"}, classifyParser.processSentence("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"glob prok","Iron"}, classifyParser.processSentence("how many Credits is glob prok Iron ? "));
        assertArrayEquals(new String[]{"tegj","L"}, classifyParser.processSentence("tegj is L"));
        assertArrayEquals(new String[]{"pish tegj glob glob"}, classifyParser.processSentence("how much is pish tegj glob glob ? "));
    }

    @Test
    void wordsStoredInHashMap(){
        ClassifyParser classifyParser = new ClassifyParser();
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("tegj is L"));
        romanCalculate.StoreItemToRomanValue(classifyParser.processSentence("prok is V"));
        assertEquals("L", romanCalculate.GetRomanValueFromItem("tegj"));
        assertEquals("V", romanCalculate.GetRomanValueFromItem("prok"));
    }


    @Test
    void wordsToRomanNumeralConversion(){

    }


}
