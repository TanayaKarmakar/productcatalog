package com.app.easy;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class ClimbingStairsLeetcode70 {
  private static int climbStairs(int n) {
    int prev = 1;
    int curr = 1;
    for(int i = 2; i <= n; i++) {
      int total = prev + curr;
      prev = curr;
      curr = total;
    }
    return curr;
  }

  public static void main(String[] args) {
    int ans = climbStairs(3);

    System.out.println(ans);
  }
}
