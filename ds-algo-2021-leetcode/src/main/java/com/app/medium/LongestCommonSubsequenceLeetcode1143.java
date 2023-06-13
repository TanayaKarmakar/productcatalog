package com.app.medium;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class LongestCommonSubsequenceLeetcode1143 {
  private static int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for(int i = 1; i <= m; i++) {
      for(int j = 1; j <= n; j++) {
        if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(longestCommonSubsequence("abcde", "ace"));
  }
}
