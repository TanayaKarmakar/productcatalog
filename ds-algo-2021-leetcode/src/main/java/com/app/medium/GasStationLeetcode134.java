package com.app.medium;

public class GasStationLeetcode134 {
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndx = -1;
        int currentDelta = 0;
        int n = gas.length;
        int failureCount = 0;

        for(int i = 0; i < n;) {
            currentDelta += gas[i] - cost[i];
            if(currentDelta < 0) {
                currentDelta = 0;
                startIndx = -1;
                failureCount++;
                if(failureCount == n)
                    return -1;
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
        System.out.println(canCompleteCircuit(gas, cost));

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
