package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/12/22
 * @project ds-algo-2021
 */
public class SingleNumberIIILeetcode260 {
  private static int[] singleNumber(int[] nums) {
    int result = 0;
    for(int i = 0; i < nums.length; i++) {
      result = result ^ nums[i];
    }

    int setBit = 0;
    for(setBit = 0; setBit < 32; setBit++) {
      if((result & (1 << setBit)) > 0)
        break;
    }

    int group1 = 0;
    int group2 = 0;
    for(int i = 0; i < nums.length; i++) {
      if((nums[i] & (1 << setBit)) > 0) {
        group1 = group1 ^ nums[i];
      } else {
        group2 = group2 ^ nums[i];
      }
    }
    return new int[] {group1, group2};
  }

  public static void main(String[] args) {
    int[] nums = {1,2,1,3,2,5};

    System.out.println(Arrays.toString(singleNumber(nums)));
  }
}
