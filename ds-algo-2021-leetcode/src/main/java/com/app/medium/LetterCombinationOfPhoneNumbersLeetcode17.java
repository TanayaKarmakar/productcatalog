package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 09/10/21
 * @project ds-algo-2021
 */
public class LetterCombinationOfPhoneNumbersLeetcode17 {
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

    private static List<String> letterCombinationsRec(String digits, int indx) {
        if(indx == digits.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> smallList = letterCombinationsRec(digits, indx + 1);
        List<String> largeList = new ArrayList<>();
        String value = map.get(digits.charAt(indx));
        for(int i = 0; i < value.length(); i++) {
            for(String str: smallList) {
                String newStr = value.charAt(i) + str;
                largeList.add(newStr);
            }
        }
        return largeList;
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();
        initMap();
        return letterCombinationsRec(digits, 0);
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("234");
        System.out.println(res);
    }
}
