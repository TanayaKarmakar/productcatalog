package com.app.medium;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumSizeSubarraySumLeetcode209 {
  private static int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int right = 0;
    int left = 0;
    int currentSum = 0;

    int minLen = (n + 1);
    while(right < n) {
      currentSum += nums[right];
      while(left <= right && currentSum >= target) {
        if(right - left + 1 < minLen) {
          minLen = right - left + 1;
        }
        currentSum -= nums[left];
        left++;
      }
      right++;
    }
    return minLen == (n + 1) ? 0: minLen;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,1,2,4,3};
    int target = 7;

    System.out.println(minSubArrayLen(target, nums));

    nums = new int[] {1,4,4};
    target = 4;

    System.out.println(minSubArrayLen(target, nums));

    nums = new int[]{1,1,1,1,1,1,1,1};
    target = 11;

    System.out.println(minSubArrayLen(target, nums));

  }
}
