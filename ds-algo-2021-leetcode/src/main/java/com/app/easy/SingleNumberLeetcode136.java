package com.app.easy;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class SingleNumberLeetcode136 {
  private static int singleNumber(int[] nums) {
    int result = 0;
    for(int i = 0; i < nums.length; i++) {
      result = result ^ nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {4,1,2,1,2};
    int ans = singleNumber(nums);

    System.out.println(ans);
  }
}
