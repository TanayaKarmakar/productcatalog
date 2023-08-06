package com.app.striver.dp;

/**
 * @author t0k02w6 on 06/08/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumPathSum {
  private static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];

    for(int i = 1; i < m; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }

    for(int i = 1; i < n; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        dp[i][j] = grid[i][j] + Integer.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] grid = {{5, 9, 6},{11, 5, 2}};
    int ans = minPathSum(grid);

    System.out.println(ans);
  }
}
