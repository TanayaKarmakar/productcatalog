package com.app.buyAndSellStocksSeries;

public class BestTimeToBuyAndSellStocksWithCooldownLeetcode309 {
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return maxProfitMemo(prices, 0, 1, dp);
    }

    private static int maxProfitMemo(int[] prices, int indx, int canBuy, Integer[][] dp) {
        if(indx >= prices.length)
            return 0;
        if(dp[indx][canBuy] == null) {
            if(canBuy == 1) {
                int option1 = -prices[indx] + maxProfitMemo(prices, indx + 1, 0, dp);
                int option2 = maxProfitMemo(prices, indx + 1, canBuy, dp);
                dp[indx][canBuy] = Integer.max(option1, option2);
            } else {
                int option1 = prices[indx] + maxProfitMemo(prices, indx + 2, 1, dp);
                int option2 = maxProfitMemo(prices, indx + 1, canBuy, dp);
                dp[indx][canBuy] = Integer.max(option1, option2);
            }
        }
        return dp[indx][canBuy];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int ans = maxProfit(prices);

        System.out.println(ans);
    }
}
