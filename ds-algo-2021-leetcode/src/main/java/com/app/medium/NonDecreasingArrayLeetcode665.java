package com.app.medium;

/**
 * @author t0k02w6 on 03/07/23
 * @project ds-algo-2021-leetcode
 */
public class NonDecreasingArrayLeetcode665 {
  private static boolean checkPossibility(int[] nums) {
    if(nums.length <= 1)
      return true;
    int n = nums.length;
    int[] lis = new int[n];
    lis[0] = 1;

    int maxLen = 1;
    for(int i = 1; i < n; i++) {
      lis[i] = 1;
      for(int j = 0; j < i; j++) {
        if(nums[j] <= nums[i]) {
          lis[i] = Integer.max(lis[i], lis[j] + 1);
        }
      }
      maxLen = Integer.max(maxLen, lis[i]);
    }

    return n - maxLen <= 1 ? true: false;
  }

  public static void main(String[] args) {
    int[] nums = {4,2,3};

    System.out.println(checkPossibility(nums));

    nums = new int[] {4,2,1};

    System.out.println(checkPossibility(nums));
  }
}
