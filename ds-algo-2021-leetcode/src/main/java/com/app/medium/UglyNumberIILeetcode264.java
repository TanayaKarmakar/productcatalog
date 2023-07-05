package com.app.medium;

/**
 * @author t0k02w6 on 28/06/23
 * @project ds-algo-2021-leetcode
 */
public class UglyNumberIILeetcode264 {
  private static int nthUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    int i2 = 0;
    int i3 = 0;
    int i5 = 0;
    for(int i = 1; i < n; i++) {
      int nextI2 = dp[i2] * 2;
      int nextI3 = dp[i3] * 3;
      int nextI5 = dp[i5] * 5;
      int min = Integer.min(nextI2, Integer.min(nextI3, nextI5));
      if(min == nextI2)
        i2++;
      if(min == nextI3)
        i3++;
      if(min == nextI5)
        i5++;
      dp[i] = min;
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(nthUglyNumber(10));
  }
}
