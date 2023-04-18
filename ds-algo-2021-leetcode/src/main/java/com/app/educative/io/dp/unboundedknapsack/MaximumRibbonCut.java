package com.app.educative.io.dp.unboundedknapsack;

import java.util.Arrays;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumRibbonCut {
  private static int maxCut(int[] ribbons, int maxLength) {
    int n = ribbons.length;
    int[] dp = new int[maxLength + 1];

    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;

    for(int j = 1; j <= maxLength; j++) {
      int result = Integer.MIN_VALUE;
      for(int i = 0; i < n; i++) {
        if(j >= ribbons[i]) {
          result = Integer.max(result, dp[j - ribbons[i]]);
        }
      }
      if(result != Integer.MIN_VALUE) {
        dp[j] = result + 1;
      }
    }
    return dp[maxLength];
  }

  public static void main(String[] args) {
    System.out.println(maxCut(new int[]{2,3,5}, 5));
    System.out.println(maxCut(new int[]{2,3}, 7));
    System.out.println(maxCut(new int[]{3,5,7}, 13));
  }
}
