package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 29/07/21
 * @project ds-algo-2021
 */
public class LetterCombinationsOfPhoneNumberLeetcode17 {
    private static Map<Character, String> map;

    private static void initMap() {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    private static List<String> letterCombinations(String digits, int indx) {
        if(indx == digits.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        List<String> smallList = letterCombinations(digits, indx + 1);
        char ch = digits.charAt(indx);
        String valStr = map.get(ch);
        List<String> finalList = new ArrayList<>();
        for(int i = 0; i < valStr.length(); i++) {
            for(String item: smallList) {
                finalList.add(valStr.charAt(i) + item);
            }
        }
        return finalList;
    }

    private static List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        initMap();
        return letterCombinations(digits, 0);
    }

    public static void main(String[] args) {
        String digits = "23";

        System.out.println(letterCombinations(digits));
    }
}
