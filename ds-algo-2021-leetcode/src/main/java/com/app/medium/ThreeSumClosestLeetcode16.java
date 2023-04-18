package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
public class ThreeSumClosestLeetcode16 {
  private static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int minDiff = Integer.MAX_VALUE;
    int closestTarget = 0;

    for(int i = 0; i < nums.length - 1; i++) {
      int start = i + 1;
      int end = nums.length - 1;
      while(start < end) {
        int currentSum = nums[i] + nums[start] + nums[end];
        int currentDiff = Math.abs(target - currentSum);
        if(minDiff > currentDiff) {
          minDiff = currentDiff;
          closestTarget = currentSum;
        }
        if(currentSum < target) {
          start++;
        } else {
          end--;
        }
      }
    }
    return closestTarget;
  }

  public static void main(String[] args) {
    int[] nums = {-1,2,1,4};
    int target = 1;

    System.out.println(threeSumClosest(nums, target));
  }
}
