package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
public class LetterCombinationsOfAPhoneNumberLeetcode17 {
    private static Map<Character, String> letterMap;

    private static void initMap() {
        letterMap = new HashMap<>();
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
    }

    private static List<String> letterCombinationsRec(String digits, int indx) {
        if(indx == digits.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> smallerValue = letterCombinationsRec(digits, indx + 1);
        String letterValue = letterMap.get(digits.charAt(indx));
        List<String> largerValue = new ArrayList<>();

        for(int i = 0; i < letterValue.length(); i++) {
            char ch = letterValue.charAt(i);
            for(String value: smallerValue) {
                largerValue.add(ch + value);
            }
        }
        return largerValue;
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits.isEmpty())
            return new ArrayList<>();
        initMap();
        return letterCombinationsRec(digits, 0);
    }

    public static void main(String[] args) {
        String str = "23";

        List<String> result = letterCombinations(str);

        System.out.println(result);
    }
}
