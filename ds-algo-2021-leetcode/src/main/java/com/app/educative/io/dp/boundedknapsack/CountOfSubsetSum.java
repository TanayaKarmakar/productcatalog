package com.app.educative.io.dp.boundedknapsack;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class CountOfSubsetSum {
  private static int countOfSubsetSum(int[] nums, int sum) {
    int n = nums.length;
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
    int sum = 4;

    int ans = countOfSubsetSum(nums, sum);

    System.out.println(ans);

    nums = new int[]{1,2,7,1,5};
    sum = 9;

    ans = countOfSubsetSum(nums, sum);

    System.out.println(ans);
  }
}
