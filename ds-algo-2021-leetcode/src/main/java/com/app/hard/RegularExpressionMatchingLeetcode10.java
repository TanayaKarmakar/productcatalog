package com.app.hard;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class RegularExpressionMatchingLeetcode10 {
  private static boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
    dp[0][0] = true;

    for(int i = 1; i <= p.length(); i++) {
      char pc = p.charAt(i - 1);
      if(pc == '*') {
        dp[i][0] = dp[i - 2][0];
      }
    }

    for(int i = 1; i < dp.length; i++) {
      for(int j = 1; j < dp[0].length; j++) {
        char sc = s.charAt(j - 1);
        char pc = p.charAt(i - 1);
        if(pc == sc || pc == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if(pc == '*') {
          dp[i][j] = dp[i - 2][j];
          char pclc = p.charAt(i - 2);
          if(pclc == '.' || sc == pclc) {
            dp[i][j] = dp[i][j] | dp[i][j - 1];
          }
        }
      }
    }

    return dp[p.length()][s.length()];
  }

  public static void main(String[] args) {
    String s = "aa";
    String p = "a";

    System.out.println(isMatch(s, p));

    s = "aa";
    p = "a*";

    System.out.println(isMatch(s, p));
  }
}
