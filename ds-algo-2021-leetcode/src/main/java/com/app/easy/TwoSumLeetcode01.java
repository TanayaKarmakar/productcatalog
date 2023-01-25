package com.app.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 25/01/23
 * @project ds-algo-2021
 */
public class TwoSumLeetcode01 {
  private static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < nums.length; i++) {
      if(map.containsKey(target - nums[i])) {
        return new int[] {i, map.get(target - nums[i])};
      }
      map.put(nums[i], i);
    }
    return new int[] {-1, -1};
  }

  public static void main(String[] args) {

  }
}
