package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class CoinChangeLeetcode322 {
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int j = 1; j <= amount; j++) {
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++) {
                if(j >= coins[i]) {
                    res = Integer.min(res, dp[j - coins[i]]);
                }
            }
            if(res != Integer.MAX_VALUE)
                dp[j] = Integer.min(dp[j], res + 1);
        }
        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
    }

    public static void main(String[] args) {

    }
}
