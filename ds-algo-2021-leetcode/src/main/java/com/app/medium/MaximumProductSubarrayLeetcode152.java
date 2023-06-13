package com.app.medium;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumProductSubarrayLeetcode152 {
  private static int maxProduct(int[] nums) {
    int n = nums.length;
    int prefix = 1;
    int suffix = 1;
    int max = Integer.MIN_VALUE;

    //boolean hasReset = false;
    for(int i = 0; i < n; i++) {
      prefix = prefix * nums[i];
      suffix = suffix * nums[n - i - 1];

      if(prefix == 0) {
        prefix = 1;
      }

      if(suffix == 0) {
        suffix = 1;
      }

      max = Integer.max(max, Integer.max(prefix, suffix));
    }
    return suffix;
  }

  public static void main(String[] args) {

  }
}
