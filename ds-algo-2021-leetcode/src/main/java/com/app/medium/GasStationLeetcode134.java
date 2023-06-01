package com.app.medium;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */
public class GasStationLeetcode134 {
  private static int canCompleteCircuit(int[] gas, int[] cost) {
    int startIndx = -1;
    int i = 0;
    int failureCount = 0;
    int n = gas.length;
    int totalCost = 0;
    while(true) {
      totalCost += gas[i] - cost[i];
      if(totalCost < 0) {
        failureCount++;
        totalCost = 0;
        startIndx = -1;
        if(failureCount == n)
          return -1;
      } else {

        if(startIndx == i)
          break;
        else if(startIndx == -1)
          startIndx = i;
      }
      i = (i + 1)%n;
    }
    return startIndx;
  }

  public static void main(String[] args) {
    int[] gas = {1,2,3,4,5};
    int[] cost = {3,4,5,1,2};
    int ans = canCompleteCircuit(gas, cost);

    System.out.println(ans);

    gas = new int[] {2,3,4};
    cost = new int[]{3,4,3};

    ans = canCompleteCircuit(gas, cost);

    System.out.println(ans);

  }
}
