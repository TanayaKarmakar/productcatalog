package com.app.medium;

import java.util.TreeMap;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class HandOfStraightsLeetcode846 {
  private static boolean isNStraightHand(int[] hand, int groupSize) {
    TreeMap<Integer, Integer> tMap = new TreeMap<>();
    for(int i = 0; i < hand.length; i++) {
      tMap.put(hand[i], tMap.getOrDefault(hand[i], 0) + 1);
    }

    while(tMap.size() > 0) {
      int firstKey = tMap.firstKey();
      for(int i = firstKey; i < (firstKey + groupSize); i++) {
        if(!tMap.containsKey(i))
          return false;
        int value = tMap.get(i);
        value--;

        if(value == 0)
          tMap.remove(i);
        else
          tMap.put(i, value);
      }
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
