package com.app.medium;

public class CoinChangeLeetcode322 {
    private static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            int res = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                if(i >= coins[j]) {
                    res = Integer.min(res, dp[i - coins[j]]);
                }
            }
            if(res != Integer.MAX_VALUE)
                res = res + 1;
            dp[i] = res;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
