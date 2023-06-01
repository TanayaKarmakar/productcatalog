package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 30/05/23
 * @project ds-algo-2021-leetcode
 */
public class LongestStringWithoutRepeatingCharactersLeetcode03 {
  private static int lengthOfLongestSubstring(String s) {
    Set<Character> charSet = new HashSet<>();
    int n = s.length();
    int left = 0;
    int right = 0;

    int max = 0;

    while(right < n) {
      while(right < n && !charSet.contains(s.charAt(right))) {
        charSet.add(s.charAt(right));
        right++;
      }
      max = Integer.max(max, (right - left));
      charSet.remove(s.charAt(left));
      left++;
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }
}
