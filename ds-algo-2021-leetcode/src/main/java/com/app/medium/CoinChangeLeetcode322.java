package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class CoinChangeLeetcode322 {
  private static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for(int j = 1; j <= amount; j++) {
      int result = Integer.MAX_VALUE;
      for(int i = 0; i < coins.length; i++) {
        if(j >= coins[i]) {
          result = Integer.min(result, dp[j - coins[i]]);
        }
      }
      if(result != Integer.MAX_VALUE)
        dp[j] = result + 1;
    }
    return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
  }

  public static void main(String[] args) {
    int[] coins = {1,2,5};
    int amount = 11;
    int ans = coinChange(coins, amount);

    System.out.println(ans);
  }
}
