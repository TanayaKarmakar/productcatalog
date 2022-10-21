package com.app.medium;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubsequenceLeetcode516 {
  private static int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    for(int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for(int l = 2; l <= n; l++) {
      int i = 0;
      int j = l - 1;
      while(i < n && j < n) {
        if(s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2 + dp[i + 1][j - 1];
        } else {
          dp[i][j] = Integer.max(dp[i + 1][j],dp[i][j - 1]);
        }
        i++;
        j++;
      }
    }
    return dp[0][n - 1];
  }

  public static void main(String[] args) {
    String str = "bbbab";
    int ans = longestPalindromeSubseq(str);

    System.out.println(ans);

  }
}
