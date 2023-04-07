package com.app.medium;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class UniquePathsLeetcode62 {
  private static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];

    for(int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for(int j = 1; j < n; j++) {
      dp[0][j] = 1;
    }

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 7));
  }
}
