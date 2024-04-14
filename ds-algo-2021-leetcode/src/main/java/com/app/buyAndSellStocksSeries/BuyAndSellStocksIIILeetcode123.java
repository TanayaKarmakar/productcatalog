package com.app.buyAndSellStocksSeries;

public class BuyAndSellStocksIIILeetcode123 {
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dpLeft = new int[n];
        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfitSoFar = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            minPriceSoFar = Integer.min(prices[i], minPriceSoFar);
            int currentProfit = prices[i] - minPriceSoFar;
            maxProfitSoFar = Integer.max(maxProfitSoFar, currentProfit);
            dpLeft[i] = maxProfitSoFar;
        }

        int maxPriceSoFar = Integer.MIN_VALUE;
        maxProfitSoFar = Integer.MIN_VALUE;

        int[] dpRight = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            maxPriceSoFar = Integer.max(maxPriceSoFar, prices[i]);
            int currentProfit = maxPriceSoFar - prices[i];
            maxProfitSoFar = Integer.max(currentProfit, maxProfitSoFar);
            dpRight[i] = maxProfitSoFar;
        }

        int maxProfit = Integer.MIN_VALUE;
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
