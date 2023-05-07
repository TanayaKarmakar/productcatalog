package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 27/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestSubstringWithAtmostKDistinctCharactersLeetcode340 {
  private static int lengthOfLongestSubstringKDistinct(String s, int k) {
    int right = 0;
    int left = 0;
    int maxlen = 0;
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    while(right < n) {
      char ch = s.charAt(right);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while(left <= right && map.size() > k) {
        if(maxlen < (right - left)) {
          maxlen = (right - left);
        }
        ch = s.charAt(left);
        int value = map.get(ch);
        if(value == 1) {
          map.remove(ch);
        } else {
          map.put(ch, --value);
        }
        left++;
      }
      right++;
    }

    if(map.size() <= k) {
      maxlen = Integer.max(right - left, maxlen);
    }
    return maxlen;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
  }
}
