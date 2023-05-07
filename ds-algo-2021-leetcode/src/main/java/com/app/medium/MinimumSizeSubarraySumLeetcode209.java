package com.app.medium;

/**
 * @author t0k02w6 on 26/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumSizeSubarraySumLeetcode209 {
  private static int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int right = 0;
    int left = 0;
    int minLen = n + 1;
    int currentSum = 0;

    while (right < n) {
      currentSum += nums[right];
      while (left <= right && currentSum >= target) {
        if (minLen > (right - left + 1)) {
          minLen = Integer.min(minLen, (right - left + 1));
        }
        currentSum -= nums[left];
        left++;
      }
      right++;
    }

    if(minLen == n + 1 && currentSum < target)
      minLen = 0;

    return minLen;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,1,2,4,3};
    int target = 7;
    int ans = minSubArrayLen(target, nums);
    System.out.println(ans);


    nums = new int[] {1,4,4};
    target = 4;
    ans = minSubArrayLen(target, nums);
    System.out.println(ans);

    nums = new int[]{1,1,1,1,1,1,1,1};
    target = 11;
    ans = minSubArrayLen(target, nums);
    System.out.println(ans);
  }
}
