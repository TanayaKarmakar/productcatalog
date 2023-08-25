package com.app.striver.dp;

/**
 * @author t0k02w6 on 09/08/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumFallingPathSum {
  private static int maxPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] dp = new int[m][n];
    for(int i = 0; i < n; i++) {
      dp[0][i] = grid[0][i];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 0; j < n; j++) {
        dp[i][j] = grid[i][j] + maxFromPrevRow(dp, i - 1, j);
      }
    }

    int maxValue = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
      maxValue = Integer.max(maxValue, dp[m - 1][i]);
    }
    return maxValue;
  }

  private static int maxFromPrevRow(int[][] dp, int prevRow, int currentCol) {
    int option1 = (currentCol - 1) >= 0 ? dp[prevRow][currentCol - 1]: Integer.MIN_VALUE;
    int option2 = dp[prevRow][currentCol];
    int option3 = (currentCol + 1) < dp[0].length ? dp[prevRow][currentCol + 1]: Integer.MIN_VALUE;
    return Integer.max(option1, Integer.max(option2, option3));
  }

  public static void main(String[] args) {

  }
}
