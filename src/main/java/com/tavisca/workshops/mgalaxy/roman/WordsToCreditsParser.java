package com.tavisca.workshops.mgalaxy.roman;

public class WordsToCreditsParser {
    public String[] parse(String query) {
        String[] words = query.split(" ");
        words = query.split(" is ");
        String[] firstPart = words[0].split(" ");

        String itemName = firstPart[firstPart.length-1];
        String amountInWords = "";

        for(int i =0; i < firstPart.length - 1; i++){
            amountInWords += firstPart[i] + " ";
        }

        String number = words[1].split(" ")[0];

        return new String[]{amountInWords.trim(), itemName, number};
    }
}
