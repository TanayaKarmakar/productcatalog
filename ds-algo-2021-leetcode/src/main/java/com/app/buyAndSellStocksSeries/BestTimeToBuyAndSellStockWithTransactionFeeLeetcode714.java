package com.app.buyAndSellStocksSeries;

public class BestTimeToBuyAndSellStockWithTransactionFeeLeetcode714 {
    private static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] bsp = new int[n];
        int[] ssp = new int[n];

        bsp[0] = -prices[0];

        for(int i = 1; i < n; i++) {
            bsp[i] = Integer.max(bsp[i - 1], ssp[i - 1] - prices[i]);
            ssp[i] = Integer.max(ssp[i - 1], bsp[i - 1] + prices[i] - fee);
        }

        return ssp[n - 1];
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;

        int ans = maxProfit(prices, fee);

        System.out.println(ans);
    }
}
