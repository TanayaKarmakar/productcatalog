package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class UniqueBinarySearchTreesLeetcode96 {
  private static int numTrees(int n) {
    if(n <= 1)
      return n;
    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
      for(int j = 0; j < i; j++) {
       //System.out.println("for i " + i + "dp["+j+"]" + dp[j] + " - dp["+(i - j - 1)+"]" + dp[i - j - 1]);
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int ans = numTrees(n);

    System.out.println(ans);
  }
}
