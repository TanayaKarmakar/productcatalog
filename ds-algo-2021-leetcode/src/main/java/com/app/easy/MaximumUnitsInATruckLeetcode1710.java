package com.app.easy;

import java.util.Arrays;

public class MaximumUnitsInATruckLeetcode1710 {
    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);
        int totalProfit = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(truckSize == 0)
                break;
            if(truckSize - boxTypes[i][0] >= 0) {
                totalProfit += (boxTypes[i][0] * boxTypes[i][1]);
                truckSize -= boxTypes[i][0];
            } else {
                totalProfit += (truckSize * boxTypes[i][1]);
                truckSize = 0;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {

    }
}
