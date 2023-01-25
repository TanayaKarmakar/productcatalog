package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 06/12/22
 * @project ds-algo-2021
 */
public class LongestSubstringAtmostTwoDistinctCharactersLeetcode159 {
  private static int lengthOfLongestSubstringTwoDistinct(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int n = s.length();
    int left = 0;
    int right = 0;
    int maxLen = Integer.MIN_VALUE;
    while(right < n) {
      char ch = s.charAt(right);
      map.put(ch, map.getOrDefault(ch, 0) + 1);

      while(left <= right && map.size() > 2) {
        char ch1 = s.charAt(left);
        int value = map.get(ch1);
        if(value == 1)
          map.remove(ch1);
        else
          map.put(ch1, --value);
        left++;
      }
      if(map.size() <= 2) {
        if((right - left + 1) > maxLen)
          maxLen = (right - left + 1);
      }
      right++;
    }
    //maxLen = Integer.max(maxLen, right - left + 1);
    return maxLen == Integer.MIN_VALUE ? 0: maxLen;
  }

  public static void main(String[] args) {
    String str = "eceba";
    System.out.println(lengthOfLongestSubstringTwoDistinct(str));

    str = "ccaabbb";
    System.out.println(lengthOfLongestSubstringTwoDistinct(str));
  }
}
