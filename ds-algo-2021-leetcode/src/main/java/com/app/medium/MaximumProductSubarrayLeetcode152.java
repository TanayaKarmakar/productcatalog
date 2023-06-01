package com.app.medium;

/**
 * @author t0k02w6 on 24/05/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumProductSubarrayLeetcode152 {
  private static int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int n = nums.length;
    int prefix = 1;
    int suffix = 1;
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
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,-2,4};

    int ans = maxProduct(nums);

    System.out.println(ans);

    nums = new int[] {-2,0,-1};
    ans = maxProduct(nums);

    System.out.println(ans);
  }
}
