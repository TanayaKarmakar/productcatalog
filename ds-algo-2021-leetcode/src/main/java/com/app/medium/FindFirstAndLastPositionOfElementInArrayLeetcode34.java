package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
public class FindFirstAndLastPositionOfElementInArrayLeetcode34 {
  private static int[] searchRange(int[] nums, int target) {
    int leftIndx = findLeftMostIndex(nums, target);
    if(leftIndx == -1)
      return new int[] {-1, -1};
    int rightIndx = findRightMostIndex(nums, target);
    return new int[] {leftIndx, rightIndx};
  }

  private static int findLeftMostIndex(int[] nums, int target) {
    int n = nums.length;
    int end = (n - 1);
    int start = 0;
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

  private static int findRightMostIndex(int[] nums, int target) {
    int n = nums.length;
    int end = (n - 1);
    int start = 0;
    while(start <= end) {
      int mid = (start + end) >> 1;
      if(nums[mid] == target && (mid == n - 1 || nums[mid + 1] != target))
        return mid;
      else if(nums[mid] > target)
        end = mid - 1;
      else
        start = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {5,7,7,8,8,10};
    int[] ans = searchRange(nums, 8);

    System.out.println(Arrays.toString(ans));
  }
}
