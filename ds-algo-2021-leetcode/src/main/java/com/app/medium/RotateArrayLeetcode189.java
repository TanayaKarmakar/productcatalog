package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/02/23
 * @project ds-algo-2021
 */
public class RotateArrayLeetcode189 {
  private static void rotate(int[] nums, int k) {
    int n = nums.length;
    if(k > n) {
      k = k % n;
    }
    reverseArray(nums, 0, n - 1);
    reverseArray(nums, 0, k - 1);
    reverseArray(nums, k, n - 1);
  }

  private static void reverseArray(int[] nums, int start, int end) {
    while(start <= end) {
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;
    rotate(nums, k);

    System.out.println(Arrays.toString(nums));
  }
}
