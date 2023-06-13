package com.app.medium;

/**
 * @author t0k02w6 on 03/06/23
 * @project ds-algo-2021-leetcode
 */
public class JumpGameIILeetcode45 {
  private static int jump(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];

    for(int i = 1; i < n; i++) {
      int result = Integer.MAX_VALUE;
      for(int j = 0; j < i; j++) {
        if(nums[j] + j >= i) {
          result = Integer.min(result, dp[j]);
        }
      }
      if(result != Integer.MAX_VALUE) {
        dp[i] = 1 + result;
      }
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {

  }
}
