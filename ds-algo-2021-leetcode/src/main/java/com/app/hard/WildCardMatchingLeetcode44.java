package com.app.hard;

/**
 * @author t0k02w6 on 17/05/23
 * @project ds-algo-2021-leetcode
 */
public class WildCardMatchingLeetcode44 {
  private static boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();

    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[m][n] = true;

    for(int i = m - 1; i >= 0; i--) {
      if(p.charAt(i) == '*') {
        dp[i][n] = dp[i + 1][n];
      }
    }

    for(int i = m - 1; i >= 0; i--) {
      for(int j = n - 1; j >= 0; j--) {
        if(s.charAt(j) == p.charAt(i) || p.charAt(i) == '?') {
          dp[i][j] = dp[i + 1][j + 1];
        } else if(p.charAt(i) == '*') {
          dp[i][j] = dp[i + 1][j] | dp[i][j + 1];
        }
      }
    }

    return dp[0][0];
  }

  public static void main(String[] args) {
    String s = "baaabab";
    String p = "ba*a?";

    boolean ans = isMatch(s, p);

    System.out.println(ans);
  }
}
