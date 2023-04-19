package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubstrings {
  private static int lps(String str) {
    if(str.length() <= 1)
      return str.length();

    int n = str.length();
    int i = 0;
    int maxLen = 1;
    while(i < n) {
      int left = i;
      int right = i;
      while(left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
        maxLen = Integer.max(maxLen, (right - left + 1));
        left--;
        right++;
      }

      left = i - 1;
      right = i;
      while(left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
        maxLen = Integer.max(maxLen, (right - left + 1));
        left--;
        right++;
      }
      i++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(lps("abdbca"));
    System.out.println(lps("cddpd"));
    System.out.println(lps("pqr"));
  }
}
