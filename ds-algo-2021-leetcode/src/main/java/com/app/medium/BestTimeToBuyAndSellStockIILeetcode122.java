package com.app.medium;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class BestTimeToBuyAndSellStockIILeetcode122 {
  private static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int start = 0;
    int n = prices.length;

    for(int i = 0; i < n;) {
      while(i + 1 < n && prices[i] > prices[i + 1]) {
        i++;
      }
      start = prices[i];


      while(i + 1 < n && prices[i] < prices[i + 1])
        i++;
      if(i < n) {
        maxProfit += (prices[i] - start);
      }

      i++;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] nums = {7,1,5,3,6,4};

    int totalProfit = maxProfit(nums);

    System.out.println(totalProfit);
  }
}
