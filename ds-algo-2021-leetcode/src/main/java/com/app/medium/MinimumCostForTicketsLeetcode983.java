package com.app.medium;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTicketsLeetcode983 {
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
                int cost1 = dp[Integer.max(i - 1, 0)] + costs[0];
                int cost7 = dp[Integer.max(i - 7, 0)] + costs[1];
                int cost30 = dp[Integer.max(i - 30, 0)] + costs[2];
                dp[i] = Integer.min(cost1, Integer.min(cost7, cost30));
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
