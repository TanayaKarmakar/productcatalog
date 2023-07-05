package com.app.medium;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
class Relation {
  protected static boolean knows(int a, int b) {
    return true;
  }
}

public class FindTheCelebrityLeetcode277 extends Relation{
  private static int findCelebrity(int n) {
    int candidate = 0;
    for(int i = 0; i < n; i++) {
      if(candidate == i)
        continue;
      if(knows(candidate, i)) {
        candidate = i;
      }
    }

    if(findCelebrity(n, candidate))
      return candidate;
    return -1;
  }

  private static boolean findCelebrity(int n, int candidate) {
    for(int i = 0; i < n; i++) {
      if(candidate == i)
        continue;
      if(knows(candidate, i) || !knows(i, candidate))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
