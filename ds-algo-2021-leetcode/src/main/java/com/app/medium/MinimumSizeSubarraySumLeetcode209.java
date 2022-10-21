package com.app.medium;

/**
 * @author t0k02w6 on 17/10/22
 * @project ds-algo-2021-leetcode
 */
public class MinimumSizeSubarraySumLeetcode209 {
  private static int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = 0;

    int minLen = Integer.MAX_VALUE;
    int currentSum = 0;
    while(right < n) {
      currentSum += nums[right];

      while(left <= right && currentSum >= target) {
        if(minLen > (right - left + 1)) {
          minLen = right - left + 1;
        }
        currentSum -= nums[left];
        left++;
      }
      right++;
    }


    return minLen == Integer.MAX_VALUE ? 0: minLen;

  }

  public static void main(String[] args) {
    System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    System.out.println(minSubArrayLen(4, new int[] {1,4,4}));
    System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
  }
}
