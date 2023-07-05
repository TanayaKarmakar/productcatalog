package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 02/07/23
 * @project ds-algo-2021-leetcode
 */
public class TargetSumLeetcode494 {
  private static int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    Map<String, Integer> map = new HashMap<>();
    return findTargetRec(nums,map,0, target, 0);
  }

  private static int findTargetRec(int[] nums, Map<String, Integer> map, int current, int target, int indx) {
    if(indx == nums.length) {
      if(current  == target)
        return 1;
      return 0;
    }
    String key = indx + ":" + current;
    if(!map.containsKey(key)) {
      int ans = findTargetRec(nums, map, current + nums[indx], target, indx + 1)
          + findTargetRec(nums, map, current - nums[indx], target, indx + 1);
      map.put(key, ans);
    }
    return map.get(key);
  }

  public static void main(String[] args) {
    int[] nums = {1};
    int target = 1;

    int ans = findTargetSumWays(nums, target);
    System.out.println(ans);
  }
}
