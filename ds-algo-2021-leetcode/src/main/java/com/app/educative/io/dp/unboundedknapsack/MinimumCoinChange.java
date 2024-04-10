package com.app.educative.io.dp.unboundedknapsack;

public class MinimumCoinChange {
    private static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            int result = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) {
                    result = Integer.min(result, dp[i - coins[j]]);
                }
            }
            if(result != Integer.MAX_VALUE) {
                dp[i] = result + 1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 5;

        int ans = minCoins(coins, amount);

        System.out.println(ans);
    }
}
