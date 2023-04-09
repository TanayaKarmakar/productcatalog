package com.app.medium;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 09/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumCostToConnectSticksLeetcode1167 {
  private static int connectSticks(int[] sticks) {
    if(sticks.length <= 1)
      return 0;
    PriorityQueue<Integer> pQ = new PriorityQueue<>();

    for(int i = 0; i < sticks.length; i++) {
      pQ.add(sticks[i]);
    }

    int totalCost = 0;
    while(!pQ.isEmpty()) {
      int val1 = pQ.poll();
      int val2 = pQ.isEmpty() ? 0: pQ.poll();

      totalCost += (val1 + val2);
      if(!pQ.isEmpty())
        pQ.add(val1 + val2);
    }

    return totalCost;
  }

  public static void main(String[] args) {
    int[] sticks = {1,8,3,5};

    int totalCost = connectSticks(sticks);

    System.out.println(totalCost);
  }
}
