package com.app.easy;

public class BestTimeToBuyAndSellStocksLeetcode121 {
    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            minPrice = Integer.min(prices[i], minPrice);
            maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};

        int ans = maxProfit(nums);

        System.out.println(ans);
    }
}
