package com.app.buyAndSellStocksSeries;

public class BuyAndSellStocksIIILeetcode123 {
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];

        int maxProfitSoFar = 0;
        int minBuyPrice = prices[0];
        for(int i = 0; i < n; i++) {
            minBuyPrice = Integer.min(minBuyPrice, prices[i]);
            int currentProfit = prices[i] - minBuyPrice;
            maxProfitSoFar = Integer.max(maxProfitSoFar, currentProfit);
            dpLeft[i] = maxProfitSoFar;
        }

        maxProfitSoFar = 0;
        int maxSellPrice = prices[n - 1];
        for(int i = n - 1; i >= 0; i--) {
            maxSellPrice = Integer.max(maxSellPrice, prices[i]);
            int currentProfit = maxSellPrice - prices[i];
            maxProfitSoFar = Integer.max(currentProfit, maxProfitSoFar);
            dpRight[i] = maxProfitSoFar;
        }

        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            maxProfit = Integer.max(maxProfit, dpLeft[i] + dpRight[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};

        int ans = maxProfit(prices);

        System.out.println(ans);
    }
}
