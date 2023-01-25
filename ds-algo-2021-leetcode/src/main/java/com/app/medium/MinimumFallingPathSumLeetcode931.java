package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 21/11/22
 * @project ds-algo-2021
 */
public class MinimumFallingPathSumLeetcode931 {
  private static int minFallingPathSum(int[][] A) {
    int m = A.length;
    int n = A[0].length;
    int[][] dp = new int[m][n];

    for(int i = 0; i < n; i++) {
      dp[0][i] = A[0][i];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int prevMin = findPrevMin(dp, i,j);
        dp[i][j] = A[i][j] + prevMin;
      }
    }

    for(int i = 0; i < m; i++) {
      System.out.println(Arrays.toString(dp[i]));
    }

    int ans = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
      ans = Integer.min(ans, dp[m - 1][i]);
    }
    return ans == Integer.MAX_VALUE ? 0: ans;
  }

  private static int findPrevMin(int[][] dp, int i, int j) {
    int option1 = (j - 1) < 0? Integer.MAX_VALUE: dp[i - 1][j - 1];
    int option2 = dp[i - 1][j];
    int option3 = (j + 1) >= dp[0].length ? Integer.MAX_VALUE: dp[i - 1][j + 1];
    return Integer.min(option1, Integer.min(option2, option3));
  }


  public static void main(String[] args) {
    int[][] A = {{2,1,3},{6,5,4},{7,8,9}};

    int ans = minFallingPathSum(A);

    System.out.println(ans);
  }
}
