package com.app.medium;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class PaintFenceLeetcode276 {
  private static int numWays(int n, int k) {
    if(n <= 1)
      return k;
    int same = k;
    int diff = k * (k - 1);
    int total = same + diff;

    for(int i = 3; i <= n; i++) {
      int currentSame = diff;
      int currentDiff = total * (k - 1);
      int currentTotal = currentSame + currentDiff;
      same = currentSame;
      diff = currentDiff;
      total = currentTotal;
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(numWays(3, 2));
  }
}
