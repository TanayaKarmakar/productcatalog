package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class TwoCitySchedulingCostLeetcode1029 {
  private static int twoCitySchedCost(int[][] costs) {
    int n = costs.length;
    int[][] costsWithDiff = new int[n][3];

    for(int i = 0; i < costs.length; i++) {
      costsWithDiff[i][0] = costs[i][0];
      costsWithDiff[i][1] = costs[i][1];
      costsWithDiff[i][2] = costs[i][0] - costs[i][1];
    }

    Arrays.sort(costsWithDiff, (c1, c2) -> c1[2] - c2[2]);

    int totalCost = 0;
    for(int i = 0; i < costsWithDiff.length / 2; i++) {
      totalCost += costsWithDiff[i][0];
    }

    for(int i = costsWithDiff.length / 2; i < costsWithDiff.length; i++) {
      totalCost += costsWithDiff[i][1];
    }

    return totalCost;
  }

  public static void main(String[] args) {
    int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
    int ans = twoCitySchedCost(costs);

    System.out.println(ans);
  }
}
