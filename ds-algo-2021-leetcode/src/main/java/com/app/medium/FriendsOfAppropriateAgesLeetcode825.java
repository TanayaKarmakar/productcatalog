package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 13/04/23
 * @project ds-algo-2021-leetcode
 */
public class FriendsOfAppropriateAgesLeetcode825 {
  private static int numFriendRequests(int[] ages) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < ages.length; i++) {
      map.put(ages[i], map.getOrDefault(ages[i], 0) + 1);
    }

    int totalCount = 0;
    for(Map.Entry<Integer, Integer> entry1: map.entrySet()) {
      for(Map.Entry<Integer, Integer> entry2: map.entrySet()) {
        if(canBeFriends(entry1.getKey(), entry2.getKey())) {
          totalCount += (entry1.getValue() * entry2.getValue());

          if (entry1.getKey() == entry2.getKey())
            totalCount -= entry1.getValue();
        }
      }
    }

    return totalCount;
  }

  private static boolean canBeFriends(Integer a, Integer b) {
    return !(b > a && b <= (0.5 * a + 7));
  }

  public static void main(String[] args) {

  }
}
