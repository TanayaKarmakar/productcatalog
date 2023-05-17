package com.app.medium.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
class HitCounter {
  Queue<Integer> q;

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
    HitCounter hc = new HitCounter();
    hc.hit(1);
    hc.hit(2);
    hc.hit(3);
    System.out.println(hc.getHits(4));
    hc.hit(300);
    System.out.println(hc.getHits(300));
    System.out.println(hc.getHits(301));
  }
}
