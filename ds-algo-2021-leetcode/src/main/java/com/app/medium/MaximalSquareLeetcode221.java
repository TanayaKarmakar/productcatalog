package com.app.medium;

/**
 * @author t0k02w6 on 02/10/22
 * @project ds-algo-2021-leetcode
 */
public class MaximalSquareLeetcode221 {
  private static int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    int[][] dp = new int[m][n];

    int maxSide = 1;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(matrix[i][j] == '1') {
          if(i == 0 || j== 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = 1 + Integer.min(dp[i - 1][j], Integer.min(dp[i][j - 1], dp[i - 1][j - 1]));
          }
          maxSide = Integer.max(maxSide, dp[i][j]);
        }
      }
    }
    return (maxSide * maxSide);
  }

  public static void main(String[] args) {

  }
}
