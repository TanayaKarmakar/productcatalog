package com.app.educative.io.dp.unboundedknapsack;

import java.util.Arrays;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumCoinChange {
  private static int minCoinChange(int[] denominations, int total) {
    int[] dp = new int[total + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for(int j = 1; j <= total; j++) {
      int result = Integer.MAX_VALUE;
      for(int i = 0; i < denominations.length; i++) {
        if(j >= denominations[i]) {
          result = Integer.min(result, dp[j - denominations[i]]);
        }
      }
      if(result != Integer.MAX_VALUE) {
        dp[j] = result + 1;
      }
    }
    return dp[total];
  }

  public static void main(String[] args) {
    int[] denominations = {1,2,3};
    int total = 5;

    System.out.println(minCoinChange(denominations, total));
  }
}
