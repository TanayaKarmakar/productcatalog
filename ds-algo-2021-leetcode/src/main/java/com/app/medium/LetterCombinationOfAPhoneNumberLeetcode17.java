package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
public class LetterCombinationOfAPhoneNumberLeetcode17 {
    private static final Map<Character, String> map = new HashMap<>();

    private static void initMap() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        initMap();
        return letterCombinationsRec(digits, digits.length() - 1);
    }

    private static List<String> letterCombinationsRec(String digits, int indx) {
        if(indx < 0) {
           List<String> res = new ArrayList<>();
           res.add("");
           return res;
        }

        List<String> smallList = letterCombinationsRec(digits, indx - 1);
        char ch = digits.charAt(indx);
        String value = map.get(ch);
        List<String> largeList = new ArrayList<>();
        for(String curr: smallList) {
            for(int i = 0; i < value.length(); i++) {
                largeList.add(curr + value.charAt(i));
            }
        }
        return largeList;
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> ans = letterCombinations(str);

        System.out.println(ans);
    }
}
