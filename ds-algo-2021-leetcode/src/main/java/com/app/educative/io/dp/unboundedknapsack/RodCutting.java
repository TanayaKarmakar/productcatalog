package com.app.educative.io.dp.unboundedknapsack;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class RodCutting {
  private static int maxProfit(int[] lengths, int[] prices, int rodLen) {
    int n = lengths.length;
    int[][] dp = new int[n][rodLen + 1];

    for(int j = 0; j <= rodLen; j++) {
      if(j >= lengths[0])
        dp[0][j] = prices[0];
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j <= rodLen; j++) {
        dp[i][j] = dp[i - 1][j];

        if(j >= lengths[i]) {
          dp[i][j] = Integer.max(dp[i][j], prices[i] + dp[i][j - lengths[i]]);
        }
      }
    }
    return dp[n - 1][rodLen];
  }

  public static void main(String[] args) {
    int[] lengths = {1,2,3,4,5};
    int[] prices = {2,6,7,10,13};
    int rodLen = 5;

    int ans = maxProfit(lengths, prices, rodLen);

    System.out.println(ans);
  }
}
