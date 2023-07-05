package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 21/06/23
 * @project ds-algo-2021-leetcode
 */
public class KDiffPairsInAnArrayLeetcode532 {
  private static int findPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
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
    int[] nums = {3,1,4,1,5};
    int k = 2;
    int ans = findPairs(nums, k);
    System.out.println(ans);
  }
}
