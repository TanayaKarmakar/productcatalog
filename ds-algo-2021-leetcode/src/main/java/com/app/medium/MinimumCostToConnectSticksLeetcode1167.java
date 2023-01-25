package com.app.medium;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 21/11/22
 * @project ds-algo-2021
 */
public class MinimumCostToConnectSticksLeetcode1167 {
  public static int connectSticks(int[] sticks) {
    PriorityQueue<Integer> pQ = new PriorityQueue<>();
    for(int stick: sticks) {
      pQ.add(stick);
    }

    int totalCost = 0;

    while (pQ.size() > 1) {
      int n1 = pQ.poll();
      int n2 = pQ.poll();
      totalCost += (n1 + n2);
      pQ.add(n1 + n2);
    }
    return totalCost;
  }

  public static void main(String[] args) {
    //System.out.println(connectSticks(new int[]{2,4,3}));
    System.out.println(connectSticks(new int[]{1,8,3,5}));
  }
}
