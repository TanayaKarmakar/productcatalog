package com.app.easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */
public class FirstNonRepeatingCharacterLeetcode387 {
  private static int firstUniqChar(String s) {
    Map<Character, List<Integer>> map = new LinkedHashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.putIfAbsent(ch, new ArrayList<>());
      map.get(ch).add(i);
    }

    for(Map.Entry<Character, List<Integer>> entry: map.entrySet()) {
      if(entry.getValue().size() == 1)
        return entry.getValue().get(0);
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(firstUniqChar("loveleetcode"));
  }
}
