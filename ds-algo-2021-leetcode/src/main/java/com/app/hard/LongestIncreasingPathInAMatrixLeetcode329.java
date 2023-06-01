package com.app.hard;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class LongestIncreasingPathInAMatrixLeetcode329 {
  private static int maxLen = 0;

  private static int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(dp[i][j] == 0) {
          int ans = dfs(matrix, dp, i, j, Integer.MIN_VALUE);
          maxLen = Integer.max(maxLen, ans);
        }
      }
    }
    return maxLen;
  }

  private static int dfs(int[][] matrix, int[][] dp, int i, int j, int prev) {
    if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || prev >= matrix[i][j])
      return 0;
    if(dp[i][j] != 0)
      return dp[i][j];
    int up = dfs(matrix, dp, i - 1, j, matrix[i][j]);
    int down = dfs(matrix, dp, i + 1, j, matrix[i][j]);
    int left = dfs(matrix, dp, i, j - 1, matrix[i][j]);
    int right = dfs(matrix, dp, i, j + 1, matrix[i][j]);

    dp[i][j] = 1 + Integer.max(Integer.max(up, down), Integer.max(left, right));
    return dp[i][j];
  }

  public static void main(String[] args) {
    int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
    int ans = longestIncreasingPath(matrix);
    System.out.println(ans);
  }
}
