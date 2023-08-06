package com.app.striver.dp;

/**
 * @author t0k02w6 on 05/08/23
 * @project ds-algo-2021-leetcode
 */
public class FrogJump {
  private static int minJump(int[] jumps) {
    int n = jumps.length;

    int[] dp = new int[n];
    dp[0] = 0;
    dp[1] = Math.abs(jumps[1] - jumps[0]);

    for(int i = 2; i < n; i++) {
      int option1 = dp[i - 1] + Math.abs(jumps[i] - jumps[i - 1]);
      int option2 = dp[i - 2] + Math.abs(jumps[i] - jumps[i - 2]);
      dp[i] = Integer.min(option1, option2);
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    int[] jumps = {30, 10, 60, 10, 60, 50};
    int ans = minJump(jumps);

    System.out.println(ans);
  }
}
