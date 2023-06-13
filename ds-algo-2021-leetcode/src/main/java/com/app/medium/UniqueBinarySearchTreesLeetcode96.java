package com.app.medium;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class UniqueBinarySearchTreesLeetcode96 {
  private static int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
      for(int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numTrees(3));
  }
}
