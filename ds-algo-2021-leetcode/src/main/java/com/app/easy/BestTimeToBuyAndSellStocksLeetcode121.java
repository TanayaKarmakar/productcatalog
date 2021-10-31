package com.app.easy;

/**
 * @author t0k02w6 on 30/10/21
 * @project ds-algo-2021
 */
public class BestTimeToBuyAndSellStocksLeetcode121 {
    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            minPrice = Integer.min(minPrice, prices[i]);
            maxDiff = Integer.max(prices[i] - minPrice, maxDiff);
        }

        if(maxDiff < 0)
            maxDiff = 0;

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};

        int ans = maxProfit(nums);

        System.out.println(ans);

        nums = new int[]{7,6,4,3,1};

        ans = maxProfit(nums);

        System.out.println(ans);
    }
}
