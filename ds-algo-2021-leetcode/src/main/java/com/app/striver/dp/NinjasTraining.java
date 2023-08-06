package com.app.striver.dp;

/**
 * @author t0k02w6 on 06/08/23
 * @project ds-algo-2021-leetcode
 */
public class NinjasTraining {
  private static int getMaximumPoints(int[][] activities) {
    int m = activities.length;
    int[][] dp = new int[m][4];

    dp[0][0] = Integer.max(activities[0][1], activities[0][2]);
    dp[0][1] = Integer.max(activities[0][0], activities[0][2]);
    dp[0][2] = Integer.max(activities[0][0], activities[0][1]);
    dp[0][3] = Integer.max(activities[0][0], Integer.max(activities[0][1], activities[0][2]));

    for(int day = 1; day < m; day++) {
      for(int last = 0; last < 4; last++) {
        dp[day][last] = 0;
        int maxi = 0;

        for(int task = 0; task < 3; task++) {
          if(task != last) {
            int point = activities[day][task] + dp[day - 1][task];
            maxi = Integer.max(maxi, point);
          }
        }
        dp[day][last] = maxi;
      }
    }

    return dp[m - 1][3];
  }

  public static void main(String[] args) {

  }
}
