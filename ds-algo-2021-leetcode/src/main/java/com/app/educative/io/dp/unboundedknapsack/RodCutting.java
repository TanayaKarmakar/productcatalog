package com.app.educative.io.dp.unboundedknapsack;

public class RodCutting {
    private static int maxProfit(int[] lengths, int[] prices, int n) {
        int len = lengths.length;
        int[][] dp = new int[len][n + 1];

        for(int i = 0; i <= n; i++) {
            if(i >= lengths[0]) {
                dp[0][i] = prices[0];
            }
        }

        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= lengths[i]) {
                    dp[i][j] = Integer.max(dp[i][j], prices[i] + dp[i][j - lengths[i]]);
                }
            }
        }

        return dp[len - 1][n];
    }

    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int rodLen = 5;

        int ans = maxProfit(lengths, prices, rodLen);

        System.out.println(ans);
    }
}
