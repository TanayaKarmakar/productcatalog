package com.app.medium;

import java.util.TreeMap;

/**
 * @author t0k02w6 on 05/07/23
 * @project ds-algo-2021-leetcode
 */
public class DivideAnArrayIntoSetOfKConsecutiveNumbersLeetcode1296 {
  private static boolean isPossibleDivide(int[] nums, int k) {
    TreeMap<Integer, Integer> tMap = new TreeMap<>();
    for(int i = 0; i < nums.length; i++) {
      tMap.put(nums[i], tMap.getOrDefault(nums[i], 0) + 1);
    }

    while(tMap.size() > 0) {
      int firstKey = tMap.firstKey();
      for(int i = firstKey; i < (firstKey + k); i++) {
        if(!tMap.containsKey(i))
          return false;
        int value = tMap.get(i);
        value--;
        if(value == 0) {
          tMap.remove(i);
        } else {
          tMap.put(i, value);
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
