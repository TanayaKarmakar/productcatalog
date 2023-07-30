package com.app.hard;

/**
 * @author t0k02w6 on 30/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumFallingPathSumIILeetcode1289 {
  private static int minFallingPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int [][]dp = new int[m][n];

    for(int i = 0; i < n; i++) {
      dp[0][i] = grid[0][i];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 0; j < n; j++) {
        dp[i][j] = grid[i][j] + findMinFromPrevRow(dp, i - 1, j, n);
      }
    }

    int min = Integer.MAX_VALUE;
    for(int j = 0; j < n; j++) {
      min = Integer.min(min, dp[m - 1][j]);
    }
    return min;
  }

  private static int findMinFromPrevRow(int[][] dp, int prevRow, int colsToToExcluded, int n) {
    int min = Integer.MAX_VALUE;
    for(int j = 0; j < n; j++) {
      if(j != colsToToExcluded) {
        min = Integer.min(min, dp[prevRow][j]);
      }
    }
    return min;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
    int ans = minFallingPathSum(grid);

    System.out.println(ans);
  }
}
