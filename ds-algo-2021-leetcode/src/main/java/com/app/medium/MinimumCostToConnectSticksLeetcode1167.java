package com.app.medium;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumCostToConnectSticksLeetcode1167 {
  private static int connectSticks(int[] sticks) {
    if(sticks.length <= 1)
      return 0;
    int totalCost = 0;
    PriorityQueue<Integer> pQ = new PriorityQueue<>();
    for(int i = 0; i < sticks.length; i++) {
      pQ.add(sticks[i]);
    }

    while(!pQ.isEmpty()) {
      int value1 = pQ.poll();
      int value2 = pQ.isEmpty() ? 0: pQ.poll();
      int res = value1 + value2;
      totalCost += res;
      if(!pQ.isEmpty())
        pQ.add(res);
    }

    return totalCost;
  }

  public static void main(String[] args) {
    int[] sticks = {2,4,3};

    int ans = connectSticks(sticks);

    System.out.println(ans);
  }
}
