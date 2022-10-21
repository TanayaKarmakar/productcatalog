package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 17/10/22
 * @project ds-algo-2021-leetcode
 */
public class KDiffPairsInAnArrayLeetcode532 {
  private static int findPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    int count = 0;
    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
      if(k == 0) {
        if(entry.getValue() > 1)
          count++;
      } else if(map.containsKey(entry.getKey() + k)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {

  }
}
