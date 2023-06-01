package com.app.medium;

/**
 * @author t0k02w6 on 30/05/23
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubstringLeetcode05 {
  private static String longestPalindrome(String s) {
    int n = s.length();
    int left = 0;
    int right = 0;
    int i = 0;
    int start = 0;
    int end = 0;
    int max = 1;
    while(i < n) {
      left = i;
      right = i;
      while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        if(max < (right - left + 1)) {
          max = right - left + 1;
          start = left;
          end = right;
        }
        left--;
        right++;
      }

      left = i - 1;
      right = i;
      while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        if(max < (right - left + 1)) {
          max = right - left + 1;
          start = left;
          end = right;
        }
        left--;
        right++;
      }
      i++;
    }
    return s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
  }
}
