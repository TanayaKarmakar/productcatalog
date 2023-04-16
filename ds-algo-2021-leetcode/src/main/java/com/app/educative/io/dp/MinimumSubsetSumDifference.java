package com.app.educative.io.dp;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumSubsetSumDifference {
  private static int findMinDiff(int[] nums) {
    int totalSum = 0;
    int n = nums.length;
    for(int i = 0; i < n; i++) {
      totalSum += nums[i];
    }

    int sum = totalSum / 2;
    boolean[][] dp = new boolean[n][sum + 1];

    for(int j = 0; j <= sum; j++) {
      dp[0][j] = (j == nums[0]);
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];

        if(j >= nums[i]) {
          dp[i][j] |= dp[i - 1][j - nums[i]];
        }
      }
    }

    if(dp[n - 1][sum])
      return 0;

    int sum1 = 0;
    for(int j = sum; j >= 0; j--) {
      if(dp[n - 1][j]) {
        sum1 = j;
        break;
      }
    }

    int sum2 = totalSum - sum1;
    return Math.abs(sum1 - sum2);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,9};

    int ans = findMinDiff(nums);

    System.out.println(ans);
  }
}
