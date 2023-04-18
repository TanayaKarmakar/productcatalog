package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubsequenceBottomUp {
  private static int lps(String str) {
    int n = str.length();
    int[][] dp = new int[n][n];

    for(int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for(int startIndx = str.length() - 1; startIndx >= 0; startIndx--) {
      for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
        if(str.charAt(startIndx) == str.charAt(endIndx)) {
          dp[startIndx][endIndx] = 2 + dp[startIndx + 1][endIndx - 1];
        } else {
          dp[startIndx][endIndx] = Integer.max(dp[startIndx + 1][endIndx], dp[startIndx][endIndx - 1]);
        }
      }
    }
    return dp[0][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(lps("abdbca"));
    System.out.println(lps("cddpd"));
    System.out.println(lps("pqr"));
  }
}
