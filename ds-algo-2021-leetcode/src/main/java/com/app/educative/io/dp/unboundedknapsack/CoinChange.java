package com.app.educative.io.dp.unboundedknapsack;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class CoinChange {
  private static int countChange(int[] denominations, int total) {
    int n = denominations.length;
    int[][] dp = new int[n][total + 1];

    for(int i = 0; i < n; i++)
      dp[i][0] = 1;

    for(int i = 0; i < n; i++) {
      for(int j = 1; j <= total; j++) {
        if(i > 0)
          dp[i][j] = dp[i - 1][j];
        if(j >= denominations[i])
          dp[i][j] += dp[i][j - denominations[i]];
      }
    }

    return dp[n - 1][total];
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    int total = 5;

    int ans = countChange(nums, total);

    System.out.println(ans);
  }
}
