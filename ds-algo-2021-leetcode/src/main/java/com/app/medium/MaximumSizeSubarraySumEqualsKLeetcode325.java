package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumSizeSubarraySumEqualsKLeetcode325 {
  private static int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> sumMap = new HashMap<>();
    int preSum = 0;
    int maxLen = 0;

    sumMap.put(0, 1);

    for(int i = 0; i < nums.length; i++) {
      preSum += nums[i];
      if(preSum == k)
        maxLen = (i + 1);
      if(sumMap.containsKey(preSum - k)) {
        maxLen = Integer.max(maxLen, (i - sumMap.get(preSum - k)));
      }
      if(!sumMap.containsKey(preSum))
        sumMap.put(preSum, i);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int[] nums = {1,-1,5,-2,3};
    int k = 3;

    System.out.println(maxSubArrayLen(nums, k));

    nums = new int[] {-2,-1,2,1};
    k = 1;

    System.out.println(maxSubArrayLen(nums, k));
  }
}
