package com.app.striver.dp;

import java.util.Scanner;

/**
 * @author t0k02w6 on 06/08/23
 * @project ds-algo-2021-leetcode
 */
public class UniquePaths {
  private static int countUniquePaths(int row, int col) {
    int [][]dp = new int[row][col];

    dp[0][0] = 1;
    for(int i = 1; i < col; i++) {
      dp[0][i] = 1;
    }

    for(int i = 1; i < row; i++) {
      dp[i][0] = 1;
    }

    for(int i = 1; i < row; i++) {
      for(int j = 1; j < col; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[row - 1][col - 1];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int row = scanner.nextInt();
    int col = scanner.nextInt();

    int ans = countUniquePaths(row, col);

    System.out.println(ans);
  }
}
