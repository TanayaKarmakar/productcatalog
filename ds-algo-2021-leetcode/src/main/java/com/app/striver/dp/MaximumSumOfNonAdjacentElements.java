package com.app.striver.dp;

/**
 * @author t0k02w6 on 05/08/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumSumOfNonAdjacentElements {
  private static int maxSum(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Integer.max(nums[0], nums[1]);

    for(int i = 2; i < n; i++) {
      dp[i] = Integer.max(dp[i - 1], nums[i] + dp[i - 2]);
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    int[] nums = {2,1,4,9};

    int ans = maxSum(nums);

    System.out.println(ans);
  }
}
