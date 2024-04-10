package com.app.educative.io.dp.unboundedknapsack;

public class CoinChange {
    private static int totalCombinations(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 5;

        int ans = totalCombinations(coins, amount);

        System.out.println(ans);
    }
}
