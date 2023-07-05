package com.app.medium;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumSizeSubarraySumLeetcode209 {
  private static int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int minSize = (n + 1);

    int left = 0;
    int right = 0;
    int currentSum = 0;
    while(right < n) {
      currentSum += nums[right];
      while(left <= right && currentSum >= target) {
        if(minSize > (right - left + 1)) {
          minSize = (right - left + 1);
        }
        currentSum -= nums[left];
        left++;
      }
      right++;
    }

    if(minSize == (n + 1) && currentSum < target)
      minSize = 0;
    return minSize;
  }

  public static void main(String[] args) {

  }
}
