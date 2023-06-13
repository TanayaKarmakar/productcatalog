package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class SortColorsLeetcode75 {
  private static void sortColors(int[] nums) {
    int low = 0;
    int mid = 0;
    int n = nums.length;
    int high = n - 1;
    while(mid <= high) {
      int current = nums[mid];
      switch (current) {
        case 0:
          swap(nums, low, mid);
          low++;
          mid++;
          continue;
        case 1:
          mid++;
          continue;
        case 2:
          swap(nums, mid, high);
          high--;
          continue;
      }
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {2,0,2,1,1,0};
    sortColors(nums);

    System.out.println(Arrays.toString(nums));

    nums = new int[]{2,0,1};
    sortColors(nums);

    System.out.println(Arrays.toString(nums));
  }
}
