package com.app.medium;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class MaximumSubarrayLeetcode53 {
  private static int maxSubArray(int[] nums) {
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i++) {
      currentSum += nums[i];

      maxSum = Integer.max(currentSum, maxSum);

      if(currentSum < 0)
        currentSum = 0;
    }
    return maxSum;
  }

  public static void main(String[] args) {

  }
}
