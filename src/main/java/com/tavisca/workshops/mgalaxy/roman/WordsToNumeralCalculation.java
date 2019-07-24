package com.tavisca.workshops.mgalaxy.roman;
import java.util.HashMap;

public class WordsToNumeralCalculation {
    public static HashMap<String, String> ItemToRomanValueHashMap = new HashMap<>();
    public static HashMap<String, Integer> ItemToCreditValueHashmap = new HashMap<>();

    public void StoreItemToRomanValue(String[] values){
        ItemToRomanValueHashMap.put(values[0], values[1]);
    }

    public static String CalculateRomanNumeralFromAmountInWords(String amountInWords){
        String[] words = amountInWords.split(" ");
        String romanNumeral = "";
        for(String word: words){
            romanNumeral += ItemToRomanValueHashMap.get(word);
        }

        if(isValidRomanNumeral(romanNumeral))
            return romanNumeral;
        else
            throw new RuntimeException("Roman Numeral Not valid");
    }

    public static boolean isValidRomanNumeral(String romanNumeral){
        return true;
    }
}
