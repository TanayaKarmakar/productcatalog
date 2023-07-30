package com.app.hard;

/**
 * @author t0k02w6 on 27/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumWindowSubsequenceLeetcode727 {
  private static String minWindow(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();

    int minLen = m + 1;
    String minWindow = "";

    int j = 0;
    for(int i = 0; i < m; i++) {
      if(s1.charAt(i) == s2.charAt(j)) {
        j++;
        if(j >= n) {
          int end = i + 1;
          j--;
          while(j >= 0) {
            if(s1.charAt(i) == s2.charAt(j)) {
              j--;
            }
            i--;
          }
          j++;
          i++;
          if(end - i < minLen) {
            minLen = (end - i);
            minWindow = s1.substring(i, end);
          }
        }
      }
    }
    return minWindow;
  }

  public static void main(String[] args) {
    String s1 = "abcdebdde";
    String s2 = "bde";

    String ans = minWindow(s1, s2);

    System.out.println(ans);
  }
}
