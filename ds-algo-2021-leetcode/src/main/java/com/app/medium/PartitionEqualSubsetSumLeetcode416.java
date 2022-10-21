package com.app.medium;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class PartitionEqualSubsetSumLeetcode416 {
  private static boolean canPartition(int[] nums) {
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    if(sum % 2 != 0)
      return false;
    int s = (sum / 2);
    int n = nums.length;
    boolean[][] dp = new boolean[n][s + 1];

    for(int i = 0; i <= s; i++) {
      if(i == nums[0])
        dp[0][i] = true;
    }

    for(int i = 1; i < n; i++) {
      for(int j = 0; j <= s; j++) {
        dp[i][j] = dp[i - 1][j];
        if(j >= nums[i]) {
          dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i]];
        }
      }
    }
    return dp[n - 1][s];
  }

  public static void main(String[] args) {

  }
}
