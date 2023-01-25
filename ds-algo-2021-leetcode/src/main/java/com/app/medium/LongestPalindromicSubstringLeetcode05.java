package com.app.medium;

/**
 * @author t0k02w6 on 25/01/23
 * @project ds-algo-2021
 */
public class LongestPalindromicSubstringLeetcode05 {
  private static String longestPalindrome(String s) {
    int maxLen = 1;
    int start = -1;
    int end = -1;
    for(int i = 0; i < s.length(); i++) {
      int left = i;
      int right = i;
      while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if(right - left + 1 > maxLen) {
          maxLen = (right - left + 1);
          start = left;
          end = right;
        }
        left--;
        right++;
      }

      left = i - 1;
      right = i;
      while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if(right - left + 1 > maxLen) {
          maxLen = (right - left + 1);
          start = left;
          end = right;
        }
        left--;
        right++;
      }
    }
    return start == -1 ? s.substring(0, 1): s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("abcd"));
    System.out.println(longestPalindrome("madam"));
  }
}
