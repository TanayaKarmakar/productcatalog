package com.app.educative.io.dp.boundedknapsack;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class TargetSum {
  private static int numWays(int[] nums, int target) {
    int totalSum = 0;
    int n = nums.length;
    for(int i = 0; i < n; i++) {
      totalSum += nums[i];
    }

    if((target + totalSum) %2 != 0)
      return 0;
    int sum = (target + totalSum) / 2;
    int[][] dp = new int[n][sum + 1];

    for(int i = 0; i < n; i++) {
      dp[i][0] = 1;
    }

    for(int j = 1; j <= sum; j++) {
      if(j == nums[0])
        dp[0][j] = 1;
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if(j >= nums[i]) {
          dp[i][j] += dp[i - 1][j - nums[i]];
        }
      }
    }
    return dp[n - 1][sum];
  }

  public static void main(String[] args) {
    int[] nums = {1,1,2,3};
    int target = 1;
    int ans = numWays(nums, target);

    System.out.println(ans);
  }
}
