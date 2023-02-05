package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/02/23
 * @project ds-algo-2021
 */
public class FirstAndLastElementOfSortedArrayLeetcode34 {
  private static int[] searchRange(int[] nums, int target) {
    int lIndx = findLeftMostIndx(nums, target);
    if(lIndx == -1)
      return new int[] {-1, -1};
    int rIndx = findRightMostIndx(nums, target);
    return new int[] {lIndx, rIndx};
  }

  private static int findRightMostIndx(int[] nums, int target) {
    int start = 0;
    int n = nums.length;
    int end = n - 1;
    while(start <= end) {
      int mid = (start + end) >> 1;
      if(nums[mid] == target && (mid == n - 1 || nums[mid + 1] != target))
        return mid;
      else if(nums[mid] <= target)
        start = mid + 1;
      else
        end = mid - 1;
    }
    return -1;
  }


  private static int findLeftMostIndx(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while(start <= end) {
      int mid = (start + end) >> 1;
      if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target))
        return mid;
      else if(nums[mid] >= target)
        end = mid - 1;
      else
        start = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {5,7,7,8,8,10};
    int target = 8;

    int[] ans = searchRange(nums, target);

    System.out.println(Arrays.toString(ans));
  }
}
