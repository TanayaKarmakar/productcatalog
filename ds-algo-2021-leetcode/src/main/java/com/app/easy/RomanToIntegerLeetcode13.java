package com.app.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 10/07/23
 * @project ds-algo-2021-leetcode
 */
public class RomanToIntegerLeetcode13 {
  private static int romanToInt(String s) {
    Map<Character, Integer> symbolMap = new HashMap<>();
    symbolMap.put('I', 1);
    symbolMap.put('V', 5);
    symbolMap.put('X', 10);
    symbolMap.put('L', 50);
    symbolMap.put('C', 100);
    symbolMap.put('D', 500);
    symbolMap.put('M', 1000);

    int n = s.length();
    int ans = symbolMap.get(s.charAt(n - 1));
    for(int i = n - 2; i >= 0; i--) {
      char currentChar = s.charAt(i);
      char nextChar = s.charAt(i + 1);
      if(symbolMap.get(currentChar) < symbolMap.get(nextChar)) {
        ans -= symbolMap.get(currentChar);
      } else {
        ans += symbolMap.get(currentChar);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
    System.out.println(romanToInt("LVIII"));
    System.out.println(romanToInt("MCMXCIV"));
  }
}
