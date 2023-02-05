package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 03/02/23
 * @project ds-algo-2021
 */
public class LongestConsecutiveSequenceLeetcode128 {
  private static int longestConsecutive(int[] nums) {
    Map<Integer, Boolean> map = new HashMap<>();

    for(int num: nums) {
      map.put(num, false);
    }

    int maxLen = 0;

    for(int el: nums) {
      int len = 0;
      int k = el;
      if(!map.get(k)) {
        while(map.containsKey(k) && !map.get(k)) {
          len++;
          map.put(k, true);
          k--;
        }

        k = el + 1;
        while(map.containsKey(k) && !map.get(k)) {
          len++;
          map.put(k, true);
          k++;
        }

        maxLen = Integer.max(maxLen, len);
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int[] nums = {100,4,200,1,3,2};
    int ans = longestConsecutive(nums);

    System.out.println(ans);
  }
}
