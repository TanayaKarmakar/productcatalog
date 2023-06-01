package com.app.medium;

/**
 * @author t0k02w6 on 23/05/23
 * @project ds-algo-2021-leetcode
 */
public class CountSquareSubmatricesWithAllOneLeetcode1277 {
  private static int countSquares(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];

    int count = 0;
    for(int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i];
      if(dp[0][i] == 1)
        count++;
    }

    for(int i = 1; i < m; i++) {
      dp[i][0] = matrix[i][0];
      if(dp[i][0] == 1)
        count++;
    }

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(matrix[i][j] == 1) {
          int option1 = dp[i - 1][j];
          int option2 = dp[i][j - 1];
          int option3 = dp[i - 1][j - 1];
          dp[i][j] = 1 + Integer.min(option1, Integer.min(option2, option3));
          count += dp[i][j];
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
    int ans = countSquares(matrix);

    System.out.println(ans);

    matrix = new int[][] {{1,0,1},{1,1,0},{1,1,0}};

    ans = countSquares(matrix);

    System.out.println(ans);
  }
}
