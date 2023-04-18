package com.app.medium;

/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
public class PalindromicSubstringsLeetcode648 {
  private static int countSubstrings(String s) {
    int n = s.length();
    int i = 0;

    int count = 0;
    while(i < n) {
      int left = i;
      int right = i;

      while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
        count++;
      }

      left = i - 1;
      right = i;

      while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
        count++;
      }
      i++;
    }

    return count;
  }

  public static void main(String[] args) {

  }
}
