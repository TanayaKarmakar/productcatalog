package com.app.hard;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class WildCardMatchingLeetcode44 {
  private static boolean isMatch(String s, String p) {
    int m = p.length();
    int n = s.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[m][n] = true;

    for(int i = m - 1; i >= 0; i--) {
      if(p.charAt(i) == '*')
        dp[i][n] = dp[i + 1][n];
    }

    for(int i = m - 1; i >= 0; i--) {
      for(int j = n - 1; j >= 0; j--) {
        char pc = p.charAt(i);
        char sc = s.charAt(j);
        if(pc == sc || pc == '?') {
          dp[i][j] = dp[i + 1][j + 1];
        } else if(pc == '*') {
          dp[i][j] = dp[i][j + 1] | dp[i + 1][j];
        }
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    System.out.println(isMatch("cb", "?a"));
    System.out.println(isMatch("aa", "*"));

  }
}
