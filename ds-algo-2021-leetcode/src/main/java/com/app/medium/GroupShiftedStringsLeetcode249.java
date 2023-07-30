package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class GroupShiftedStringsLeetcode249 {
  private static List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();

    List<List<String>> result = new ArrayList<>();
    for(String currentString: strings) {
      String key = generateKey(currentString);
      if(!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(currentString);
    }

    for(Map.Entry<String, List<String>> entry: map.entrySet()) {
      result.add(entry.getValue());
    }

    return result;
  }

  private static String generateKey(String currentString) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < currentString.length(); i++) {
      int val1 = currentString.charAt(0) - '0';
      int val2 = currentString.charAt(i) - '0';
      int res = (val1 - val2 + 26) % 26;
      sb.append(res).append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] strs = {"abc","bcd","acef","xyz","az","ba","a","z"};
    List<List<String>> result = groupStrings(strs);

    System.out.println(result);
  }
}
