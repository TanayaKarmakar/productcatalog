package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 27/06/23
 * @project ds-algo-2021-leetcode
 */
public class ContinuousSubarraySumLeetcode523 {
  private static boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int preSum = 0;

    map.put(0, -1);

    for(int i = 0; i < nums.length; i++) {
      preSum += nums[i];
      if(k != 0)
        preSum = preSum % k;
      if(map.containsKey(preSum)) {
        if(i - map.get(preSum) > 1)
          return true;
      }
      map.put(preSum, i);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {23,2,4,6,7};
    int k = 6;

    System.out.println(checkSubarraySum(nums, k));
  }
}
