package com.tavisca.workshops.mgalaxy.roman;
import java.util.HashMap;

public class RomanNumeralCalculation {
    public HashMap<String, String> ItemToRomanValueHashMap = new HashMap<>();
    public HashMap<String, Double> ItemToCreditValueHashmap = new HashMap<>();

    public void StoreItemToRomanValue(String[] values){
        ItemToRomanValueHashMap.put(values[0], values[1]);
    }

    public void StoreItemToCreditValue(String key, double value){
        ItemToCreditValueHashmap.put(key, value);
    }

    public String GetRomanValueFromItem(String key){
        return ItemToRomanValueHashMap.get(key);
    }

    public double GetCreditFromItem(String key){
        return ItemToCreditValueHashmap.get(key);
    }

    public String CalculateRomanNumeralFromAmountInWords(String amountInWords){
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

    // Todo : Implement the function finding whether given roman numeral is correct or not.
    public static boolean isValidRomanNumeral(String romanNumeral){
        return true;
    }
}
