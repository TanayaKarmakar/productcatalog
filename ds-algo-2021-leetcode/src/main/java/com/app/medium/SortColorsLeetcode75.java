package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class SortColorsLeetcode75 {
  private static void sortColors(int[] nums) {
    int n = nums.length;
    int low = 0;
    int mid = 0;
    int high = n - 1;

    while(mid <= high) {
      int item = nums[mid];
      switch (item) {
        case 0:
          swap(nums, low, mid);
          low++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swap(nums, mid, high);
          high--;
          break;
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
  }
}
