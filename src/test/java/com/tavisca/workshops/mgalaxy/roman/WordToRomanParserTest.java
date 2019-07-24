package com.tavisca.workshops.mgalaxy.roman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class WordToRomanParserTest {

    @Test
    void canParseWordToRomanNumeralStatement(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();

        assertArrayEquals(new String[]{"glob","I"}, wordToRomanParser.parse("glob is I"));
        assertArrayEquals(new String[]{"prok","V"}, wordToRomanParser.parse("prok is V"));
        assertArrayEquals(new String[]{"pish","X"}, wordToRomanParser.parse("pish is X"));
        assertArrayEquals(new String[]{"tegj","L"}, wordToRomanParser.parse("tegj is L"));

    }

    @Test
    void canParseCreditCalculationStatement(){
        WordsToCreditsParser wordToRomanParser = new WordsToCreditsParser();
        assertArrayEquals(new String[]{"glob glob","Silver","34"}, wordToRomanParser.parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"glob prok","Gold","57800"}, wordToRomanParser.parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"pish pish","Iron","3910"}, wordToRomanParser.parse("pish pish Iron is 3910 Credits"));

    }

    @Test
    void canAnswerWordToAmountQuestions(){

    }

    @Test
    void canAnswerCreditFindingQuestions(){
        QuestionToCreditWordsAndItemNameParser parser = new QuestionToCreditWordsAndItemNameParser();
        assertArrayEquals(new String[]{"glob prok","Silver"}, parser.parse("how many Credits is glob prok Silver ? "));
        assertArrayEquals(new String[]{"glob prok","Gold"}, parser.parse("how many Credits is glob prok Gold ? "));
        assertArrayEquals(new String[]{"glob prok","Iron"}, parser.parse("how many Credits is glob prok Iron ? "));

    }


}
