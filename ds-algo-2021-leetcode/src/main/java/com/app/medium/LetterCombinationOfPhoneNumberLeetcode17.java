package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class LetterCombinationOfPhoneNumberLeetcode17 {
  private static void initMap(Map<Character, String> map) {
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
    if(digits.isEmpty())
      return new ArrayList<>();
    Map<Character, String> digitMap = new HashMap<>();
    initMap(digitMap);

    return combinationRec(digits, digitMap, 0);
  }

  private static List<String> combinationRec(String digits, Map<Character, String> digitMap, int indx) {
    if(indx == digits.length()) {
      List<String> result = new ArrayList<>();
      result.add("");
      return result;
    }
    List<String> smallList = combinationRec(digits, digitMap, indx + 1);
    String str = digitMap.get(digits.charAt(indx));

    List<String> list = new ArrayList<>();
    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      for(String curr: smallList) {
        list.add(ch + curr);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    String digits = "23";
    List<String> result = letterCombinations(digits);

    System.out.println(result);
  }
}
