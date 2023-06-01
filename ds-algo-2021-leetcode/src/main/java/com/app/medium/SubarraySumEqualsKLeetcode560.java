package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class SubarraySumEqualsKLeetcode560 {
  private static int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    int preSum = 0;
    int count = 0;
    for(int i = 0; i < nums.length; i++) {
      preSum += nums[i];
      if(preSum == k)
        count++;
      if(map.containsKey(preSum - k))
        count += map.get(preSum - k);
      map.put(preSum, map.getOrDefault(preSum, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1};

    int k = 2;

    int ans = subarraySum(nums, k);

    System.out.println(ans);

    nums = new int[] {1,2,3};
    k = 3;

    ans = subarraySum(nums, k);

    System.out.println(ans);
  }
}
