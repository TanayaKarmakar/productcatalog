package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class SingleNumberIIILeetcode260 {
  private static int[] singleNumber(int[] nums) {
    int xor = 0;
    for(int i = 0; i < nums.length; i++) {
      xor = xor ^ nums[i];
    }

    int tmp = xor;
    int j = 0;
    while(tmp != 0) {
      if((tmp & 1) == 1) {
        break;
      }
      j++;
      tmp = tmp >> 1;
    }

    int group1Xor = 0;
    int group2Xor = 0;

    for(int i = 0; i < nums.length; i++) {
      if(((nums[i] >> j) & 1) == 1) {
        group1Xor = group1Xor ^ nums[i];
      } else {
        group2Xor = group2Xor ^ nums[i];
      }
    }

    return new int[] {group1Xor, group2Xor};
  }

  public static void main(String[] args) {
    int[] nums = {1,2,1,3,2,5};
    int[] ans = singleNumber(nums);

    System.out.println(Arrays.toString(ans));
  }
}
