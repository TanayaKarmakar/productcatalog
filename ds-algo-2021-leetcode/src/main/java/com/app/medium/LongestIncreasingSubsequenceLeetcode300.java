package com.app.medium;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class LongestIncreasingSubsequenceLeetcode300 {
  private static int lengthOfLIS(int[] nums) {
    if(nums.length <= 1)
      return nums.length;
    int n = nums.length;
    int[] lis = new int[n];

    int maxLen = 1;
    lis[0] = 1;
    for(int i = 1; i < nums.length; i++) {
      lis[i] = 1;
      for(int j = 0; j < i; j++) {
        if(nums[j] < nums[i])
          lis[i] = Integer.max(lis[i], lis[j] + 1);
      }
      maxLen = Integer.max(maxLen, lis[i]);
    }
    return maxLen;
  }

  public static void main(String[] args) {

  }
}
