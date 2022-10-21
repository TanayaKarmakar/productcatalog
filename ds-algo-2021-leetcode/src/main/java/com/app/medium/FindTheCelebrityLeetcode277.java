//package com.app.medium;
//
///**
// * @author t0k02w6 on 19/10/22
// * @project ds-algo-2021-leetcode
// */
//abstract class Relation {
//  boolean knows(int a, int b) {
//    return true;
//  }
//}
//
//class Solution extends Relation {
//  public int findCelebrity(int n) {
//    int candidate = 0;
//    for(int i = 0; i < n; i++) {
//      if(candidate == i)
//        continue;
//      if(knows(candidate, i))
//        candidate = i;
//    }
//
//    if(isCelebrity(n, candidate))
//      return candidate;
//    return -1;
//  }
//
//  private boolean isCelebrity(int n, int candidate) {
//    for(int i = 0; i < n; i++) {
//      if(candidate == i)
//        continue;
//      if(knows(candidate, i) || !knows(i, candidate))
//        return false;
//    }
//    return true;
//  }
//}
//
//public class FindTheCelebrityLeetcode277 {
//  public static void main(String[] args) {
//
//  }
//
//}
