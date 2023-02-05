package com.app.easy;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class BestTimeToBuyAndSellStockLeetcode121 {
  private static int maxProfit(int[] prices) {
    int minPrice = prices[0];
    int maxProfit = Integer.MIN_VALUE;
    for(int i = 0; i < prices.length; i++) {
      minPrice = Integer.min(prices[i], minPrice);
      maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
    }

    return maxProfit;
  }

  public static void main(String[] args) {

  }
}
