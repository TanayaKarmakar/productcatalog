package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */
public class LetterCombinationOfAPhoneNumberLeetcode17 {
  private static Map<Character, String> digitMap;

  private static void initMap() {
    digitMap = new HashMap<>();
    digitMap.put('2', "abc");
    digitMap.put('3', "def");
    digitMap.put('4', "ghi");
    digitMap.put('5', "jkl");
    digitMap.put('6', "mno");
    digitMap.put('7', "pqrs");
    digitMap.put('8', "tuv");
    digitMap.put('9', "wxyz");
  }

  private static List<String> letterCombinations(String digits) {
    if(digits.isEmpty() || digits.length() == 1) {
      return new ArrayList<>();
    }
    initMap();
    List<String> result = letterCombinationsRec(digits, 0);
    return result;
  }

  private static List<String> letterCombinationsRec(String digits, int indx) {
    if(indx == digits.length()) {
      List<String> result = new ArrayList<>();
      result.add("");
      return result;
    }
    List<String> smallResult = letterCombinationsRec(digits, indx + 1);
    List<String> biggerResult = new ArrayList<>();
    String value = digitMap.get(digits.charAt(indx));
    for(int i = 0; i < value.length(); i++) {
      char ch = value.charAt(i);
      for(String el: smallResult) {
        biggerResult.add(ch + el);
      }
    }
    return biggerResult;
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
}
