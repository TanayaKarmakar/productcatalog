package com.app.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class LongestSubstringWithoutRepeatingCharactersLeetcode03 {
  private static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int right = 0;
    int left = 0;

    int maxLen = 0;
    Set<Character> set = new HashSet<>();
    while(right < n) {
      while(right < n && !set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        right++;
      }
      maxLen = Integer.max(maxLen, (right - left));
      set.remove(s.charAt(left));
      left++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String s = "abcabcbb";

    System.out.println(lengthOfLongestSubstring(s));

    s = "bbbbb";

    System.out.println(lengthOfLongestSubstring(s));
  }
}
