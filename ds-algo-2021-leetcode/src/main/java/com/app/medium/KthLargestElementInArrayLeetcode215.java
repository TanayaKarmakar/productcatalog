package com.app.medium;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */

public class KthLargestElementInArrayLeetcode215 {
  private static int findKthLargest(int[] nums, int k) {
    k = nums.length - k;
    return kThLargestRec(nums, k, 0, nums.length - 1);
  }

  private static int kThLargestRec(int[] nums, int k, int start, int end) {
    if(start > end)
      return -1;
    int pivot = findPivot(nums, start, end);
    if(pivot > k)
      return kThLargestRec(nums, k, start, pivot - 1);
    else if(pivot < k)
      return kThLargestRec(nums, k, pivot + 1, end);
    return nums[pivot];
  }

  private static int findPivot(int[] nums, int start, int end) {
    int i = start - 1;
    int pivot = nums[end];
    for(int j = start; j <= (end - 1); j++) {
      if(nums[j] <= pivot) {
        i++;
        swap(nums, i, j);
      }
    }
    swap(nums, (i + 1), end);
    return (i + 1);
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {

  }
}
