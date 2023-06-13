package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumCostForTicketLeetcode983 {
  private static int mincostTickets(int[] days, int[] costs) {
    int lastDay = days[days.length - 1];
    int[] dp = new int[lastDay + 1];

    Set<Integer> daySet = new HashSet<>();
    for(int day: days) {
      daySet.add(day);
    }

    for(int i = 1; i <= lastDay; i++) {
      if(!daySet.contains(i)) {
        dp[i] = dp[i - 1];
      } else {
        int day1 = dp[Integer.max(i - 1, 0)] + costs[0];
        int day7 = dp[Integer.max(i - 7, 0)] + costs[1];
        int day30 = dp[Integer.max(i - 30, 0)] + costs[2];
        dp[i] = Integer.min(day1, Integer.min(day7, day30));
      }
    }
    return dp[lastDay];
  }

  public static void main(String[] args) {
    int[] days = {1,4,6,7,8,20};
    int[] costs = {2,7,15};

    int ans = mincostTickets(days, costs);

    System.out.println(ans);
  }
}
