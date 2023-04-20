package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestRepeatingSubsequence {
  private static int findLrs(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    for(int i = 0; i < n; i++) {
      if(s.charAt(i) == s.charAt(0) && i != 0) {
        dp[i][0] = 1;
      }
    }

    for(int j = 0; j < n; j++) {
      if(s.charAt(j) == s.charAt(0) && j != 0) {
        dp[0][j] = 1;
      }
    }

    int maxLen = 0;
    for(int i = 1; i < n; i++) {
      for(int j = 1; j < n; j++) {
        if(s.charAt(i) == s.charAt(j) && i != j) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
        }
        maxLen = Integer.max(maxLen, dp[i][j]);
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(findLrs("tomorrow"));
    System.out.println(findLrs("aabdbcec"));
  }
}
