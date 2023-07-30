package com.app.medium;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumFallingPathSumLeetcode931 {
  private static int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    int[][] dp = new int[m][n];

    for(int i = 0; i < n; i++) {
      matrix[0][i] = dp[0][i];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 0; j < n; j++) {
        dp[i][j] = matrix[i][j] + findMinFromPrev(dp, i, j);
      }
    }

    int minValue = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
      minValue = Integer.min(minValue, dp[m - 1][i]);
    }
    return minValue;
  }

  private static int findMinFromPrev(int[][] dp, int i, int j) {
    int option1 = (j - 1 >= 0) ? dp[i - 1][j - 1]: Integer.MAX_VALUE;
    int option2 = dp[i - 1][j];
    int option3 = (j + 1 < dp[0].length) ? dp[i - 1][j + 1]: Integer.MAX_VALUE;
    return Integer.min(option1, Integer.min(option2, option3));
  }


  public static void main(String[] args) {
    int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

    int ans = minFallingPathSum(matrix);

    System.out.println(ans);
  }
}
