package com.app.easy;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
public class SearchInsertPositionLeetcode35 {
  private static int searchInsert(int[] nums, int target) {
    int n = nums.length;
    int start = 0;
    int end = (n - 1);

    while(start <= end) {
      int mid = (start + end) >> 1;
      if(nums[mid] == target)
        return mid;
      else if(nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
  }
}
