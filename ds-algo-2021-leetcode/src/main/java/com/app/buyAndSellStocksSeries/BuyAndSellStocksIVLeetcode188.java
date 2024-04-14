package com.app.buyAndSellStocksSeries;

public class BuyAndSellStocksIVLeetcode188 {
    private static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j < n; j++) {
                int maxProfit = dp[i][j - 1];

                for(int i1 = 0; i1 < j; j++) {
                    maxProfit = Integer.max(maxProfit, dp[i - 1][i1] + (prices[j] - prices[i1]));
                }
                dp[i][j] = maxProfit;
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {

    }
}
