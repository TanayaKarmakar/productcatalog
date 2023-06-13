package com.app.medium.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */

class HitCounter {
  private Queue<Integer> q;

  public HitCounter() {
    q = new LinkedList<>();
  }

  public void hit(int timestamp) {
    q.add(timestamp);
  }

  public int getHits(int timestamp) {
    while(!q.isEmpty() && q.peek() <= (timestamp - 300)) {
      q.poll();
    }
    return q.size();
  }
}

public class HitCounterLeetcode362 {
  public static void main(String[] args) {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);
    hitCounter.hit(2);
    hitCounter.hit(3);
    System.out.println(hitCounter.getHits(4));
    hitCounter.hit(300);
    System.out.println(hitCounter.getHits(300));
    System.out.println(hitCounter.getHits(301));
  }
}
