package com.app.medium;

/**
 * @author t0k02w6 on 21/04/23
 * @project ds-algo-2021-leetcode
 */
public class MaximalSquareLeetcode221 {
  private static int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int maxLen = 0;

    for(int i = 0; i < m; i++) {
      dp[i][0] = matrix[i][0] == '1' ? 1: 0;
      maxLen = Integer.max(maxLen, dp[i][0]);
    }

    for(int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i] == '1' ? 1: 0;
      maxLen = Integer.max(maxLen, dp[0][i]);
    }


    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(matrix[i][j] == '1') {
          int option1 = dp[i - 1][j];
          int option2 = dp[i][j - 1];
          int option3 = dp[i - 1][j - 1];
          dp[i][j] = 1 + Integer.min(option1, Integer.min(option2, option3));
          maxLen = Integer.max(maxLen, dp[i][j]);
        }
      }
    }
    return (maxLen * maxLen);
  }

  public static void main(String[] args) {
    char[][] matrix = {{'0'}};
    int ans = maximalSquare(matrix);

    System.out.println(ans);
//    char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},
//        {'1','1','1','1','1'},{'1','0','0','1','0'}};
//
//    int ans = maximalSquare(matrix);
//
//    System.out.println(ans);
  }
}
