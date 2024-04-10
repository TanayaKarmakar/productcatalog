package com.app.educative.io.dp.unboundedknapsack;

public class UnboundedKnapsack {
    private static int maxProfit(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n][capacity + 1];

        for(int i = 0; i <= capacity; i++) {
            if(i >= weights[0]) {
                dp[0][i] = profits[0] + dp[0][i - weights[0]];
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= capacity; j++) {
                dp[i][j] =dp[i - 1][j];
                if(j >= weights[i]) {
                    dp[i][j] = Integer.max(dp[i][j], profits[i] + dp[i][j - weights[i]]);
                }
            }
        }

        return dp[n - 1][capacity];

    }

    public static void main(String[] args) {
        int[] weights = {1,2,3};
        int[] profits = {15,20,50};
        int capacity = 5;

        int ans = maxProfit(weights, profits, capacity);

        System.out.println(ans);
    }
}
