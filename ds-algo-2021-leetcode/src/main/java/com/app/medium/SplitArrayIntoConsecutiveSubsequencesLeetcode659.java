package com.app.medium;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 04/07/23
 * @project ds-algo-2021-leetcode
 */
public class SplitArrayIntoConsecutiveSubsequencesLeetcode659 {
  private static boolean isPossible(int[] nums) {
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> {
      if(a[1] == b[1]) {
        int la = a[1] - a[0] + 1;
        int lb = b[1] - b[0] + 1;
        return la - lb;
      }
      return a[1] - b[1];
    });

    for(int el: nums) {
      while(!pQ.isEmpty() && pQ.peek()[1] + 1 < el) {
        int len = pQ.peek()[1] - pQ.peek()[0] + 1;
        if(len < 3)
          return false;
        pQ.poll();
      }

      if(pQ.size() == 0 || pQ.peek()[1] == el) {
        pQ.add(new int[]{el, el});
      } else {
        int[] previousRange = pQ.poll();
        pQ.add(new int[]{previousRange[0], el});
      }
    }

    while(!pQ.isEmpty()) {
      int[] currentRange = pQ.poll();
      int len = currentRange[1] - currentRange[0] + 1;
      if(len < 3)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
