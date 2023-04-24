package com.app.medium;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubsequenceLeetcode516 {
  private static int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for(int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for(int i = n - 2; i >= 0; i--) {
      for(int j = i + 1; j < n; j++) {
        if(s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2 + dp[i + 1][j - 1];
        } else {
          dp[i][j] = Integer.max(dp[i][j - 1], dp[i + 1][j]);
        }
      }
    }
    return dp[0][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("bbbab"));
  }
}
