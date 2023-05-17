package com.app.hard;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
public class SpliArrayLargestSumLeetcode410 {
  private static int splitArray(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
    int totalSum = 0;
    for(int i = 0; i < nums.length; i++) {
      max = Integer.max(max, nums[i]);
      totalSum += nums[i];
    }

    int start = max;
    int end = totalSum;

    while(start <= end) {
      int mid = (start + end) >> 1;
      if(isSplitPossible(nums, k, mid))
        end = mid - 1;
      else
        start = mid + 1;
    }
    return start;
  }

  private static boolean isSplitPossible(int[] nums, int k, int mid) {
    int count = 1;
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      if(sum + nums[i] <= mid) {
        sum += nums[i];
      } else {
        sum = nums[i];
        count++;
        if(count > k)
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(splitArray(new int[] {7,2,5,10,8}, 2));
    System.out.println(splitArray(new int[]{1,2,3,4,5},2));
  }
}
