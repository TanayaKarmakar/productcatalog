package com.app.medium;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class GasStationLeetcode134 {
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int startIndx = -1;
        int currentDelta = 0;
        int failureCount = 0;
        for(int i = 0; i < n;) {
            currentDelta += gas[i] - cost[i];
            if(currentDelta < 0) {
                currentDelta = 0;
                startIndx = -1;
                failureCount++;
                if(failureCount == n)
                    break;
            } else {
                if(startIndx == i)
                    break;
                else if(startIndx == -1) {
                    startIndx = i;
                }
            }
            i = (i + 1) % n;
        }
        return startIndx;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        int ans = canCompleteCircuit(gas, cost);

        System.out.println(ans);


    }
}
