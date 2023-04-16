package com.app.educative.io.dp;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class ZeroOneKnapSackProblem {
  private static int maxProfit(int[] weights, int[] profits, int maxCap) {
    int n = weights.length;
    int[][] dp = new int[n][maxCap + 1];

    for(int j = 0; j <= maxCap; j++) {
      if(j >= weights[0]) {
        dp[0][j] = profits[0];
      }
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j <= maxCap; j++) {
        int profit1 = dp[i - 1][j];

        int profit2 = 0;
        if(j >= weights[i]) {
          profit2 = profits[i] + dp[i - 1][j - weights[i]];
        }
        dp[i][j] = Integer.max(profit1, profit2);
      }
    }

    printTheWeights(weights, profits, maxCap, dp);

    return dp[n - 1][maxCap];
  }

  private static void printTheWeights(int[] weights, int[] profits, int maxCap, int[][] dp) {
    int totalProfit = dp[weights.length - 1][maxCap];


    for(int i = weights.length - 1; i > 0; i--) {
      if(totalProfit != dp[i - 1][maxCap]) {
        System.out.println("Weights - " + weights[i]);
        maxCap -= weights[i];
        totalProfit -= profits[i];
      }
    }

    if(totalProfit > 0) {
      System.out.println("Weights - " + weights[0]);
      totalProfit -= profits[0];
      maxCap -= weights[0];
    }
  }

  public static void main(String[] args) {
    int[] weights = {1,2,3,5};
    int[] profits = {1,6,10,16};
    int maxCap = 7;

    int ans = maxProfit(weights, profits, maxCap);

    System.out.println(ans);
  }
}
