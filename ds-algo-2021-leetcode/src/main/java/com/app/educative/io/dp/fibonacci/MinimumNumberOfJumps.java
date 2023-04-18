package com.app.educative.io.dp.fibonacci;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumNumberOfJumps {
  private static int minJumps(int[] nums) {
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
        dp[i] = result + 1;
      }
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(minJumps(new int[]{2, 1, 1, 1, 4}));
  }
}
