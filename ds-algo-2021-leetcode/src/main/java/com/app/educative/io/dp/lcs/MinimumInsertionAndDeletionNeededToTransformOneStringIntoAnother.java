package com.app.educative.io.dp.lcs;

/**
 * @author t0k02w6 on 19/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumInsertionAndDeletionNeededToTransformOneStringIntoAnother {
  private static int findLcs(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();

    int[][] dp = new int[m + 1][n + 1];

    for(int i = 1; i <= m; i++) {
      for(int j = 1; j <= n; j++) {
        if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    String s1 = "abdca";
    String s2 = "cbda";
    int ans = findLcs(s1, s2);

    System.out.println("Minimum number of deletion needed - " + (s1.length() - ans));
    System.out.println("Minimum number of insertion needed - " + (s2.length() - ans));
  }
}
