package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 27/06/23
 * @project ds-algo-2021-leetcode
 */
public class ContiguousArrayLeetcode525 {
  private static int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int preSum = 0;

    int maxLen = 0;
    for(int i = 0; i < nums.length; i++) {
      preSum += (nums[i] == 0 ? -1: 1);
      if(preSum == 0)
        maxLen = (i + 1);
      if(map.containsKey(preSum)) {
        maxLen = Integer.max(maxLen, i - map.get(preSum));
      } else
        map.put(preSum, i);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,0,1,1,0,1,1,1};
    int ans = findMaxLength(nums);

    System.out.println(ans);
  }
}
