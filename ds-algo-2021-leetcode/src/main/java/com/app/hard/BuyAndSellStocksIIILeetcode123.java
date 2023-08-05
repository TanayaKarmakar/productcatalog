package com.app.hard;

/**
 * @author t0k02w6 on 31/07/23
 * @project ds-algo-2021-leetcode
 */
public class BuyAndSellStocksIIILeetcode123 {
  private static int maxProfit(int[] prices) {
    int n = prices.length;
    int[] dpLeft = new int[n];
    int meanSoFar = prices[0];

    for(int i = 1; i < n; i++) {
      dpLeft[i] = dpLeft[i - 1];
      if(meanSoFar > prices[i]) {
        meanSoFar = prices[i];
      }
      int maxIfSoldToday = prices[i] - meanSoFar;
      dpLeft[i] = Integer.max(dpLeft[i], maxIfSoldToday);
    }

    int maxSoFar = prices[n - 1];
    int[] dpRight = new int[n];
    for(int i = n - 2; i >= 0; i--) {
      dpRight[i] = dpRight[i + 1];
      if(maxSoFar < prices[i]) {
        maxSoFar = prices[i];
      }

      int maxIfBoughtToday = maxSoFar - prices[i];
      dpRight[i] = Integer.max(dpRight[i], maxIfBoughtToday);
    }


    int overAllProfit = 0;
    for(int i = 0; i < n; i++) {
      overAllProfit = Integer.max(overAllProfit, dpLeft[i] + dpRight[i]);
    }
    return overAllProfit;
  }

  public static void main(String[] args) {
    int[] prices = {3,3,5,0,0,3,1,4};
    int ans = maxProfit(prices);

    System.out.println(ans);
  }
}
