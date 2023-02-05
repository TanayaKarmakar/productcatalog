package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 31/01/23
 * @project ds-algo-2021
 */
public class PerfectSquaresLeetcode279 {
  private static int numSquares(int n) {
    int sqrt = (int) Math.sqrt(n);


    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 1;

    for(int i = 2; i <= n; i++) {
      for(int j = 1; j <= sqrt; j++) {
        if(j * j == i) {
          dp[i] = 1;
        } else if(i >= (j * j)){
          dp[i] = Integer.min(dp[i], dp[i - (j * j)] + 1);
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 12;
    int ans = numSquares(n);

    System.out.println(ans);
  }
}
