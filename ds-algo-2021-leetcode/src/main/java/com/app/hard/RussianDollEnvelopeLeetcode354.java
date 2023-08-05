package com.app.hard;

import java.util.Arrays;

/**
 * @author t0k02w6 on 30/07/23
 * @project ds-algo-2021-leetcode
 */
public class RussianDollEnvelopeLeetcode354 {
  private static int maxEnvelopes(int[][] envelopes) {
    if(envelopes.length <= 1)
      return envelopes.length;
    Arrays.sort(envelopes, (e1, e2) -> e1[0] - e2[0]);

    int n = envelopes.length;
    int[] dp = new int[n];
    dp[0] = 1;
    int maxEnv = 1;
    for(int i = 1; i < n; i++) {
      dp[i] = 1;
      for(int j = 0; j < i; j++) {
        if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
          dp[i] = Integer.max(dp[i], dp[j] + 1);
        }
      }
      maxEnv = Integer.max(maxEnv, dp[i]);
    }
    return maxEnv;
  }

  public static void main(String[] args) {
    int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
    int ans = maxEnvelopes(envelopes);

    System.out.println(ans);
  }
}
