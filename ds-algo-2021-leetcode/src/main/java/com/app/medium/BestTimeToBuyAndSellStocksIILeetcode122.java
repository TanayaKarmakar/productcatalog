package com.app.medium;

public class BestTimeToBuyAndSellStocksIILeetcode122 {
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int start = 0;
        int maxprofit = 0;

        for(int i = 0; i < n; ) {
            while(start + 1 < n && prices[start] > prices[start + 1]) {
                start++;
            }

            int end = start + 1;
            while(end + 1 < n && prices[end] < prices[end + 1]) {
                end++;
            }
            if(start < n && end < n)
                maxprofit += (prices[end] - prices[start]);
            start = end + 1;
            i = start;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
