package com.app.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 25/01/23
 * @project ds-algo-2021
 */
public class RomanToIntegerLeetcode13 {
  private static int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int ans = map.get(s.charAt(s.length() - 1));

    for(int i = s.length() - 2; i >= 0; i--) {
      char curr = s.charAt(i);
      char prev = s.charAt(i + 1);
      if(map.get(curr) < map.get(prev)) {
        ans -= map.get(curr);
      } else {
        ans += map.get(curr);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String s = "III";

    System.out.println(romanToInt(s));

    s = "LVIII";

    System.out.println(romanToInt(s));

    s = "MCMXCIV";

    System.out.println(romanToInt(s));
  }
}
