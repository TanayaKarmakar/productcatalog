package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 20/10/22
 * @project ds-algo-2021-leetcode
 */
public class ShortestWayToFormStringLeetcode1055 {
  private static int shortestWay(String source, String target) {
    Set<Character> sourceSet = new HashSet<>();
    for(int i = 0; i < source.length(); i++) {
      sourceSet.add(source.charAt(i));
    }

    for(int i = 0; i < target.length(); i++) {
      if(!sourceSet.contains(target.charAt(i)))
        return -1;
    }

    int m = source.length();
    int n = target.length();
    int i = 0;
    int j = 0;
    int count = 0;

    while(j < n) {
      if(i == m) {
        i = 0;
        count++;
      }
      if(source.charAt(i) == target.charAt(j)) {
        j++;
      }
      i++;
    }
    return count + 1;
  }

  public static void main(String[] args) {

  }
}
