package com.app.medium;

import java.util.Arrays;

public class TwoCitySchedulingCostLeetcode1029 {
    private static int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] dist = new int[n][3];

        for(int i = 0; i < n; i++) {
            dist[i][0] = costs[i][0];
            dist[i][1] = costs[i][1];
            dist[i][2] = costs[i][0] - costs[i][1];
        }

        Arrays.sort(dist, (d1, d2) -> d1[2] - d2[2]);

        int m = n/ 2;
        int totalCost = 0;
        for(int i = 0; i < m; i++) {
            totalCost += dist[i][0];
        }

        for(int i = m; i < n; i++) {
            totalCost += dist[i][1];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};

        int ans = twoCitySchedCost(costs);

        System.out.println(ans);
    }
}
