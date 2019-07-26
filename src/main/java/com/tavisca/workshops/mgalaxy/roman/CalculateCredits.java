package com.tavisca.workshops.mgalaxy.roman;

public class CalculateCredits {
    public double CalculateCredit(String[] Values, RomanNumeralCalculator romanCalculate){
        double number = RomanToArabic.convert(romanCalculate.CalculateRomanNumeralFromAmountInWords(Values[0]));
        double creditPerItem = romanCalculate.GetCreditFromItem(Values[1]);
        double answer = number*creditPerItem;
        return answer;
    }

    public void CalculateCreditPerItem(String[] Output, RomanNumeralCalculator romanCalculate){
        double numberOfItems = RomanToArabic.convert(romanCalculate.CalculateRomanNumeralFromAmountInWords(Output[0]));
        double credits = Integer.parseInt(Output[2]);
        romanCalculate.StoreItemToCreditValue(Output[1], credits/numberOfItems);
    }
}
