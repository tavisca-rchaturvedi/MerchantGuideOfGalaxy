package com.tavisca.workshops.mgalaxy.roman;

public class CalculateCredits {
    public double CalculateCredit(String[] Values){
        double number = RomanToArabic.convert(RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords(Values[0]));
        double creditPerItem = RomanNumeralCalculation.ItemToCreditValueHashmap.get(Values[1]);
        double answer = number*creditPerItem;
        return answer;
    }

    public void CalculateCreditPerItem(String[] Output){
        double numberOfItems = RomanToArabic.convert(RomanNumeralCalculation.CalculateRomanNumeralFromAmountInWords(Output[0]));
        double credits = Integer.parseInt(Output[2]);
        RomanNumeralCalculation.ItemToCreditValueHashmap.put(Output[1], credits/numberOfItems);
    }
}
