package com.tavisca.workshops.mgalaxy.roman;

public class CalculateCredits {
    public double calculateCredit(String[] Values, RomanNumeralCalculator romanCalculate){
        double number = RomanToArabic.convert(romanCalculate.calculateRomanNumeralFromAmountInWords(Values[0]));
        double creditPerItem = romanCalculate.GetCreditFromItem(Values[1]);
        double answer = number*creditPerItem;
        return answer;
    }

    public void calculateCreditPerItem(String[] Output, RomanNumeralCalculator romanCalculate){
        double numberOfItems = RomanToArabic.convert(romanCalculate.calculateRomanNumeralFromAmountInWords(Output[0]));
        double credits = Integer.parseInt(Output[2]);
        romanCalculate.StoreItemToCreditValue(Output[1], credits/numberOfItems);
    }
}
