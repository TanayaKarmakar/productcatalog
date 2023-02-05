package com.app.medium;

/**
 * @author t0k02w6 on 31/01/23
 * @project ds-algo-2021
 */
public class ProductOfArrayExcepSelfLeetcode238 {
  private static int[] productExceptSelf(int[] nums) {
    int n= nums.length;
    int left = 1;
    int[] result = new int[n];
    for(int i = 0; i < n; i++) {
      result[i] = left;
      left = left * nums[i];
    }

    int right = 1;
    for(int i = n - 1; i >= 0; i--) {
      result[i] = result[i] * right;
      right = right * nums[i];
    }

    return result;
  }

  public static void main(String[] args) {

  }
}
