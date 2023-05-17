package com.app.medium;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
public class SearchInASortedRotatedArrayLeetcode33 {
  private static int findPivot(int[] nums) {
    int n = nums.length;
    int start = 0;
    int end = (n - 1);

    while(start <= end) {
      int mid = (start + end) >> 1;
      if(mid < (n - 1) && nums[mid] > nums[mid + 1])
        return mid;
      else if(mid > 0 && nums[mid - 1] > nums[mid])
        return (mid - 1);
      else if(nums[start] <= nums[mid])
        start = mid + 1;
      else
        end = mid - 1;
    }
    return -1;
  }

  private static int binarySearch(int[] nums, int target, int start, int end) {
    while(start <= end) {
      int mid = (start + end) >> 1;
      if(nums[mid] == target)
        return mid;
      else if(nums[mid] > target)
        end = mid - 1;
      else
        start = mid + 1;
    }
    return -1;
  }

  private static int search(int[] nums, int target) {
    int pivotIndx = findPivot(nums);
    if(pivotIndx == -1)
      return binarySearch(nums, target, 0, nums.length - 1);
    else if(target >= nums[0] && target < nums[pivotIndx])
      return binarySearch(nums, target, 0, pivotIndx);
    else
      return binarySearch(nums, target, pivotIndx + 1, nums.length - 1);
  }

  public static void main(String[] args) {

  }
}
