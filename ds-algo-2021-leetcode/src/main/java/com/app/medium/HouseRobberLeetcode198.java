package com.app.medium;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class HouseRobberLeetcode198 {
  private static int rob(int[] nums) {
    if(nums.length == 0)
      return 0;
    if(nums.length == 1)
      return nums[0];
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

  }
}
