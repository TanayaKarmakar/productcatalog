package com.app.medium;

import java.util.TreeMap;

/**
 * @author t0k02w6 on 09/04/23
 * @project ds-algo-2021-leetcode
 */
public class HandOfStraightsLeetcode846 {
  private static boolean isNStraightHand(int[] hand, int groupSize) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for(int i = 0; i < hand.length; i++) {
      map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
    }

    while(!map.isEmpty()) {
      int start = map.firstKey();
      for(int i = start; i < (start + groupSize); i++) {
        if(!map.containsKey(i))
          return false;
        int value = map.get(i);
        value--;
        if(value == 0)
          map.remove(i);
        else
          map.put(i, value);
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,6,2,3,4,7,8};
    int groupSize = 3;

    boolean ans = isNStraightHand(nums, groupSize);

    System.out.println(ans);
  }
}
