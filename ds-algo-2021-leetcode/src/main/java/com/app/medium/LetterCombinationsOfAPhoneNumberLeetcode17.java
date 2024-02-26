package com.app.medium;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberLeetcode17 {
    private static List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> ans = helper(digits, 0, map);
        return ans;
    }

    private static List<String> helper(String str, int indx, Map<Character, String> map) {
        if(indx == str.length()) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        List<String> smallerList = helper(str, indx + 1, map);
        List<String> biggerList = new ArrayList<>();
        String value = map.get(str.charAt(indx));
        for(int i = 0; i < value.length(); i++) {
            for(String str1: smallerList) {
                biggerList.add(value.charAt(i) + str1);
            }
        }
        return biggerList;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");

        System.out.println(list);
    }
}
