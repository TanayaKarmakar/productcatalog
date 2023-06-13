package com.app.hard;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/06/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumProfitInJobSchedulingLeetcode1235 {
  private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    int[][] jobInfo = new int[n][3];

    for(int i = 0; i < n; i++) {
      jobInfo[i] = new int[] {startTime[i], endTime[i], profit[i]};
    }

    Arrays.sort(jobInfo, (j1, j2) -> j1[0] - j2[0]);

    int[][] dp = new int[n][2];

    int maxProfit = 0;
    dp[0] = new int[]{jobInfo[0][1], jobInfo[0][2]};
    maxProfit = dp[0][1];

    for(int i = 1; i < n; i++) {
      int currentEndTime = jobInfo[i][1];
      int currentProfit = jobInfo[i][2];
      for(int j = 0; j < i; j++) {
        if(dp[j][0] <= jobInfo[i][0]) {
          if(dp[j][1] + jobInfo[i][2] > currentProfit) {
            currentProfit = dp[j][1] + jobInfo[i][2];
          }
        }
      }
      dp[i] = new int[]{currentEndTime, currentProfit};
      maxProfit = Integer.max(maxProfit, currentProfit);
    }
    return maxProfit;
  }

  public static void main(String[] args) {

  }
}
