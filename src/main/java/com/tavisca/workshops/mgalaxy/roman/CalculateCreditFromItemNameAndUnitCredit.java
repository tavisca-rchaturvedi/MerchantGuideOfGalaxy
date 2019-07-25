package com.tavisca.workshops.mgalaxy.roman;

public class CalculateCreditFromItemNameAndUnitCredit {
    public double CalculateCredit(String[] Values){
        double number = RomanToArabic.convert(RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords(Values[0]));
        double creditPerItem = RomanNumeralCalculation.ItemToCreditValueHashmap.get(Values[1]);
        double answer = number*creditPerItem;
        return answer;
    }
}
