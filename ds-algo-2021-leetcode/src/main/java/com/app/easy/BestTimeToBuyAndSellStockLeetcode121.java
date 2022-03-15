package com.app.easy;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class BestTimeToBuyAndSellStockLeetcode121 {
    private static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrices = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            minPrices = Integer.min(minPrices, prices[i]);
            maxProfit = Integer.max(prices[i] - minPrices, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int ans = maxProfit(nums);

        System.out.println(ans);
    }
}
