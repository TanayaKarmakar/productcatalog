package com.app.educative.io.dp.fibonacci;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class HouseThief {
  private static int maxProfit(int[] nums) {
    if(nums.length == 0)
      return 0;
    if(nums.length == 1)
      return nums[0];
    int n = nums.length;
    int[] dp = new int[n];

    dp[0] = nums[0];
    dp[1] = Integer.max(nums[1], nums[0]);

    for(int i = 2; i < n; i++) {
      dp[i] = Integer.max(dp[i - 1], nums[i] + dp[i - 2]);
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    int[] nums = {2, 5, 1, 3, 6, 2, 4};
    int ans = maxProfit(nums);

    System.out.println(ans);
  }
}
