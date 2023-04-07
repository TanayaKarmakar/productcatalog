package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class ShortestWayToFormStringLeetcode1055 {

  private static int shortestWay(String source, String target) {
    int count = 0;
    Set<Character> sourceSet = new HashSet<>();

    for(int i = 0; i < source.length(); i++) {
      sourceSet.add(source.charAt(i));
    }

    int i = 0;
    int j = 0;
    int m = source.length();
    int n = target.length();

    while(j < n) {
      i = 0;
      while(i < m && j < n) {
        char t = target.charAt(j);
        if(!sourceSet.contains(t))
          return -1;
        if(source.charAt(i) == target.charAt(j)) {
          j++;
        }
        i++;
      }
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(shortestWay("abc", "abcbc"));
    System.out.println(shortestWay("abc", "acdbc"));
    System.out.println(shortestWay("xyz", "xzyxz"));
  }
}
