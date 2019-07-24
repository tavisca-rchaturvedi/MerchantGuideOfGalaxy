package com.tavisca.workshops.mgalaxy.roman;
import java.util.HashMap;

public class AnswerQuery {
    public static HashMap<String, String> ItemToRomanValueHashMap = new HashMap<>();

    public void StoreItemToRomanValue(String[] values){
        ItemToRomanValueHashMap.put(values[0], values[1]);
    }
}
