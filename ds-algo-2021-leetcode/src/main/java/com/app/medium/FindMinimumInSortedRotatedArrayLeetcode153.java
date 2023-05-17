package com.app.medium;

/**
 * @author t0k02w6 on 14/05/23
 * @project ds-algo-2021-leetcode
 */
public class FindMinimumInSortedRotatedArrayLeetcode153 {
  private static int findMinInternal(int[] nums) {
    int n = nums.length;
    int start = 0;
    int end = (n - 1);

    while (start <= end) {
      int mid = (start + end) >> 1;
      if(mid + 1 < n && nums[mid] > nums[mid + 1])
        return mid;
      else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid])
        return (mid - 1);
      else if(nums[start] <= nums[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  private static int findMin(int[] nums) {
    if(nums.length == 1)
      return nums[0];

    int indx = findMinInternal(nums);
    return nums[indx + 1];
  }

  public static void main(String[] args) {

  }
}
