package com.app.medium;

/**
 * @author t0k02w6 on 13/06/23
 * @project ds-algo-2021-leetcode
 */
public class BestTimeToBuyAndSellStockIILeetcode122 {
  private static int maxProfit(int[] prices) {
    int n = prices.length;
    int maxProfit = 0;
    int start = 0;
    int end = 0;
    for(int i = 0; i < n;) {
      while(i + 1 < n && prices[i] > prices[i + 1]) {
        i++;
      }
      start = prices[i];

      while(i + 1 < n && prices[i] < prices[i + 1]) {
        i++;
      }
      end = prices[i];

      maxProfit += (end - start);
      i++;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] nums = {7,1,5,3,6,4};
    int ans = maxProfit(nums);

    System.out.println(ans);
  }
}
