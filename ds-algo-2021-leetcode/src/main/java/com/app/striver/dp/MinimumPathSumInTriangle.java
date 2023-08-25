package com.app.striver.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 08/08/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumPathSumInTriangle {
  private static int minPathSum(List<List<Integer>> triangle) {
    int nRows = triangle.size();
    int nCols = triangle.get(nRows - 1).size();

    int[][] dp = new int[nRows][nCols];

    for(int i = 0; i < nCols; i++) {
      dp[nRows - 1][i] = triangle.get(nRows - 1).get(i);
    }

    for(int i = nRows - 2; i >= 0; i--) {
      for(int j = i; j >= 0; j--) {
        int down = dp[i + 1][j];
        int digonal = dp[i + 1][j + 1];
        dp[i][j] = triangle.get(i).get(j) + Integer.min(down, digonal);
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();

  }
}
