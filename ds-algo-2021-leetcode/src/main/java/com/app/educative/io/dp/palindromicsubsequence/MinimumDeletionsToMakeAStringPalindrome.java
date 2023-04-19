package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumDeletionsToMakeAStringPalindrome {
  private static int minDeletions(String str) {
    int n = str.length();
    int[][] dp = new int[n][n];

    for(int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for(int startIndx = n - 1; startIndx >= 0; startIndx--) {
      for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
        if(str.charAt(startIndx) == str.charAt(endIndx)) {
          dp[startIndx][endIndx] = 2 + dp[startIndx + 1][endIndx - 1];
        } else {
          int option1 = dp[startIndx + 1][endIndx];
          int option2 = dp[startIndx][endIndx - 1];
          dp[startIndx][endIndx] = Integer.max(option1, option2);
        }
      }
    }

    return (n - dp[0][n - 1]);
  }

  public static void main(String[] args) {
    System.out.println(minDeletions("abdbca"));
    System.out.println(minDeletions("cddpd"));
    System.out.println(minDeletions("pqr"));
  }
}
