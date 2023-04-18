package com.app.educative.io.dp.boundedknapsack;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class EqualSubsetSumPartition {
  private static boolean canPartition(int[] nums) {
    int totalSum = 0;
    int n = nums.length;

    for(int i = 0; i < n; i++) {
      totalSum += nums[i];
    }

    if(totalSum % 2 != 0)
      return false;

    int sum = totalSum / 2;
    boolean[][] dp = new boolean[n][sum + 1];

    for(int i = 0; i <= sum; i++) {
      if(i == nums[0]) {
        dp[0][i] = true;
      }
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];

        if(j >= nums[i]) {
          dp[i][j] |= dp[i - 1][j - nums[i]];
        }
      }
    }

    return dp[n - 1][sum];
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};

    boolean ans = canPartition(nums);

    System.out.println(ans);

    nums = new int[]{1,2,3,5};

    ans = canPartition(nums);

    System.out.println(ans);
  }
}
