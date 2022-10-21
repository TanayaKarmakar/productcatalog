package com.app.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */

class HitCounter {
  private Deque<Integer> q = null;

  public HitCounter() {
    q = new LinkedList<>();
  }

  public void hit(int timestamp) {
    q.add(timestamp);

  }

  public int getHits(int timestamp) {
    while(!q.isEmpty() && q.peekFirst() < (timestamp - 300))
      q.pollFirst();
    return q.size();
  }
}

public class DesignHitCounterLeetcode362 {
  public static void main(String[] args) {

  }
}
