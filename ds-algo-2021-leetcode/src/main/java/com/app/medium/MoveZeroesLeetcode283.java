package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 06/02/23
 * @project ds-algo-2021
 */
public class MoveZeroesLeetcode283 {
  private static void moveZeroes(int[] nums) {
    int n = nums.length;
    int i = -1;

    for(int j = 0; j < n; j++) {
      if(nums[j] != 0) {
        i++;
        swap(nums, i, j);
      }
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,3,12};

    moveZeroes(nums);

    System.out.println(Arrays.toString(nums));
  }
}
