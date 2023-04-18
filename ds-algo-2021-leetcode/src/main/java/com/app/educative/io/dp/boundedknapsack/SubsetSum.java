package com.app.educative.io.dp.boundedknapsack;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class SubsetSum {
  private static boolean canGetSum(int[] nums, int s) {
    int n = nums.length;
    boolean[][] dp = new boolean[n][s + 1];

    for(int i = 0; i <= s; i++) {
      dp[0][i] = i == nums[0];
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j <= s; j++) {
        dp[i][j] = dp[i - 1][j];

        if(j >= nums[i]) {
          dp[i][j] |= dp[i - 1][j - nums[i]];
        }
      }
    }

    return dp[n - 1][s];
  }

  public static void main(String[] args) {
    System.out.println(canGetSum(new int[]{1,2,3,7}, 6));
  }
}
