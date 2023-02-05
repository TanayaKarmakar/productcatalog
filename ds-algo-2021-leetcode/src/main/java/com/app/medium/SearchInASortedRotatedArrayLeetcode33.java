package com.app.medium;

/**
 * @author t0k02w6 on 31/01/23
 * @project ds-algo-2021
 */
public class SearchInASortedRotatedArrayLeetcode33 {
  private static int search(int[] nums, int target) {
    int n = nums.length;
    int pivotIndx = findPivot(nums, 0, n - 1);
    if(pivotIndx == -1)
      return binarySearch(nums, 0, n - 1, target);
    else if(target >= nums[0] && target <= nums[pivotIndx])
      return binarySearch(nums, 0, pivotIndx, target);
    else
      return binarySearch(nums, pivotIndx + 1, n - 1, target);
  }

  private static int binarySearch(int[] nums, int start, int end, int target) {
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

  private static int findPivot(int[] nums, int start, int end) {
    while(start <= end) {
      int mid = (start + end) >> 1;
      if(mid - 1 >= 0 && nums[mid - 1] > nums[mid])
        return mid - 1;
      else if(mid + 1 < nums.length && nums[mid] > nums[mid + 1])
        return mid;
      else if(nums[start] <= nums[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {

  }
}
