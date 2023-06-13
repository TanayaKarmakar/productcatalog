package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class LongestConsecutiveSequenceLeetcode128 {
  private static int longestConsecutive(int[] nums) {
    if(nums.length <= 1)
      return nums.length;
    Map<Integer, Boolean> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], false);
    }

    int maxLen = 1;
    for(int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      int currentLen = 0;
      while(map.containsKey(currentNum) && !map.get(currentNum)) {
        map.put(currentNum, true);
        currentNum--;
        currentLen++;
      }

      currentNum = nums[i] + 1;
      while(map.containsKey(currentNum) && !map.get(currentNum)) {
        map.put(currentNum, true);
        currentNum++;
        currentLen++;
      }

      maxLen = Integer.max(maxLen, currentLen);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
  }
}
