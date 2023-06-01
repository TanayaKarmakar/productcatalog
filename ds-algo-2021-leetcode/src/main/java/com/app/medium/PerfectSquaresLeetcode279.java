package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 23/05/23
 * @project ds-algo-2021-leetcode
 */
public class PerfectSquaresLeetcode279 {
  private static int numSquares(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;

    int sqrt = (int)Math.sqrt(n);
    for(int i = 2; i <= n; i++) {
      dp[i] = Integer.MAX_VALUE;
      for(int j = 1; j <= sqrt; j++) {
        if(j * j == i) {
          dp[i] = 1;
        } else if(i >= j * j) {
          dp[i] = Integer.min(dp[i], 1 + dp[i - (j * j)]);
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int ans = numSquares(n);

    System.out.println(ans);

    scanner.close();
  }
}
