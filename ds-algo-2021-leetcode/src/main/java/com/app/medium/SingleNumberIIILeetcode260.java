package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class SingleNumberIIILeetcode260 {
  private static int[] singleNumber(int[] nums) {
    int xor = 0;
    for(int i = 0; i < nums.length; i++) {
      xor = xor ^ nums[i];
    }

    int j = 0;
    int temp = xor;
    while(temp != 0) {
      if((temp & 1) == 1) {
        break;
      }
      temp = temp >> 1;
      j++;
    }

    int g1 = 0;
    int g2 = 0;
    for(int i = 0; i < nums.length; i++) {
      if(((nums[i] >> j) & 1) == 1) {
        g1 = g1 ^ nums[i];
      } else {
        g2 = g2 ^ nums[i];
      }
    }

    return new int[] {g1, g2};
  }

  public static void main(String[] args) {
    int[] nums = {1,2,1,3,2,5};
    int[] ans = singleNumber(nums);

    System.out.println(Arrays.toString(ans));
  }
}
