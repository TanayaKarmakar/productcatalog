package com.app.medium;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class CoinChangeIILeetcode518 {
  private static int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];

    dp[0] = 1;
    for(int i = 0; i < coins.length; i++) {
      for(int j = 1; j <= amount; j++) {
        if(j >= coins[i])
          dp[j] += dp[j - coins[i]];
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    int amount = 3;
    int[] coins = {2};

    int ans = change(amount, coins);

    System.out.println(ans);
  }
}
