package com.app.easy;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class MissingNumberLeetcode268 {
  private static int missingNumber(int[] nums) {
    int n = nums.length;
    int totalSum = 0;
    int arraySum = 0;
    for(int i = 0; i < n; i++) {
      totalSum += i;
      arraySum += nums[i];
    }
    return (totalSum + n - arraySum);
  }

  public static void main(String[] args) {
    int[] nums = {3,0,1};
    int ans = missingNumber(nums);

    System.out.println(ans);
  }
}
