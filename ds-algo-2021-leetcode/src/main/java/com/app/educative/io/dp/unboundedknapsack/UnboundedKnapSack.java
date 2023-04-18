package com.app.educative.io.dp.unboundedknapsack;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class UnboundedKnapSack {
  private static int findMaxProfit(int[] weights, int[] profits, int weight) {
    int n = weights.length;
    int[][] dp = new int[n][weight + 1];

    for(int j = 0; j <= weight; j++) {
      if(j >= weights[0])
        dp[0][j] = profits[0];
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j <= weight; j++) {
        dp[i][j] = dp[i - 1][j];
        if(j >= weights[i]) {
          dp[i][j] = Integer.max(dp[i][j], profits[i] + dp[i][j - weights[i]]);
        }
      }
    }
    return dp[n - 1][weight];
  }

  public static void main(String[] args) {
    int[] profits = {15, 50, 60, 90};
    int[] weights = {1,3,4,5};
    int capacity = 8;

    int ans = findMaxProfit(weights, profits, capacity);

    System.out.println(ans);
  }
}
