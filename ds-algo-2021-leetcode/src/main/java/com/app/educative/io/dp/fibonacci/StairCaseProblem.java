package com.app.educative.io.dp.fibonacci;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class StairCaseProblem {
  private static int numWays(int n) {
    int []dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2; i <= n; i++) {
      int option1 = dp[i - 1];
      int option2 = dp[i - 2];
      int option3 = 0;
      if(i >= 3)
        option3 = dp[i - 3];
      dp[i] = option1 + option2 + option3;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numWays(3));
    System.out.println(numWays(4));
  }
}
