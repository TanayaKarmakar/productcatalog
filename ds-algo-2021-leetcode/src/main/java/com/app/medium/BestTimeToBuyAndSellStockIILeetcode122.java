package com.app.medium;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class BestTimeToBuyAndSellStockIILeetcode122 {
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int totalProfit = 0;
        int i = 0;
        while(i < n) {
            while(i + 1 < n && prices[i] > prices[i + 1]) {
                i++;
            }
            int start = prices[i];
            i = i + 1;
            while(i + 1 < n && prices[i] < prices[i + 1]) {
                i++;
            }
            if(i < n) {
                int end = prices[i];
                totalProfit += (end - start);
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int ans = maxProfit(nums);

        System.out.println(ans);
    }
}
