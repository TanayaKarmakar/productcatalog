package com.app.striver.dp;

/**
 * @author t0k02w6 on 05/08/23
 * @project ds-algo-2021-leetcode
 */
public class FrogJumpMaxKSteps {
  private static int minJumps(int[] jumps, int k) {
    int n = jumps.length;
    int[] dp = new int[n];
    dp[0] = 0;

    for(int i = 1; i < n; i++) {
      int min = Integer.MAX_VALUE;
      for(int j = 1; j <= k; j++) {
        if(i - j >= 0) {
          min = dp[i - j] + Math.abs(jumps[i] - jumps[i - j]);
        }
      }
      if(min != Integer.MAX_VALUE)
        dp[i] = min;
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    int[] jumps = {30, 10, 60, 10, 60, 50};
    int k = 3;
    int ans = minJumps(jumps, k);

    System.out.println(ans);
  }
}
