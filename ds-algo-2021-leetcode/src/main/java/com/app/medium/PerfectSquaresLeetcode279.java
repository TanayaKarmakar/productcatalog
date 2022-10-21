package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/10/22
 * @project ds-algo-2021-leetcode
 */
public class PerfectSquaresLeetcode279 {

  private static int numSquares(int n) {
    int[] dp = new int[n + 1];
    for(int i = 1; i <= n; i++) {
      int min = n;
      for(int j = 1; j < i; j++) {
        if((i - j * j) >= 0) {
          min = Integer.min(min, dp[i - j * j]);
        }
      }
      if(min != n)
        dp[i] = min + 1;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 12;
    int ans = numSquares(n);

    System.out.println(ans);
  }
}
