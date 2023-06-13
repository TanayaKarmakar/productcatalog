package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 06/06/23
 * @project ds-algo-2021-leetcode
 */
public class ProductOfArrayExceptSelfLeetcode238 {
  private static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];

    int leftValue = 1;
    for(int i = 0; i < n; i++) {
      left[i] = leftValue;
      leftValue = leftValue * nums[i];
    }

    int rightValue = 1;
    for(int i = n - 1; i >= 0; i--) {
      right[i] = rightValue;
      rightValue = rightValue * nums[i];
    }

    for(int i = 0; i < n; i++) {
      left[i] = left[i] * right[i];
    }

    return left;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    int[] ans = productExceptSelf(nums);

    System.out.println(Arrays.toString(ans));

  }
}
