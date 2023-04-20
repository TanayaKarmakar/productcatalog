package com.app.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 19/04/23
 * @project ds-algo-2021-leetcode
 */
public class UglyNumberIILeetcode264 {
  private static int nThUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    int i2 = 0;
    int i3 = 0;
    int i5 = 0;

    for(int i = 1; i < n; i++) {
      int nextI2 = dp[i2] * 2;
      int nextI3 = dp[i3] * 3;
      int nextI5 = dp[i5] * 5;
      int nextUgly = Integer.min(nextI2, Integer.min(nextI3, nextI5));
      if(nextUgly == nextI2)
        i2++;
      if(nextUgly == nextI3)
        i3++;
      if(nextUgly == nextI5)
        i5++;
      dp[i] = nextUgly;
    }

    //System.out.println(Arrays.toString(dp));

    return dp[n - 1];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    System.out.println(nThUglyNumber(num));
  }
}
