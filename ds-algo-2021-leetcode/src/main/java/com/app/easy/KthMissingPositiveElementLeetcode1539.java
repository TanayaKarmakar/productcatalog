package com.app.easy;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
public class KthMissingPositiveElementLeetcode1539 {
  private static int findKthPositive(int[] arr, int k) {
    int n = arr.length;
    int start = 0;
    int end = (n - 1);

    while(start <= end) {
      int mid = (start + end) >> 1;
      int diff = arr[mid] - (mid + 1);
      if(diff > k)
        end = mid - 1;
      else
        start = mid + 1;
    }
    return start + k;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    int k = 2;

    System.out.println(findKthPositive(nums, k));

    nums = new int[] {2,3,4,7,11};
    k = 5;
    System.out.println(findKthPositive(nums, k));
  }
}
