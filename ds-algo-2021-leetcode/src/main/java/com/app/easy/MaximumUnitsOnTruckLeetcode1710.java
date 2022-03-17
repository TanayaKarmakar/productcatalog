package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class MaximumUnitsOnTruckLeetcode1710 {
    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);

        int total = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(boxTypes[i][0] > truckSize) {
                total += (truckSize * boxTypes[i][1]);
                break;
            } else {
                total += (boxTypes[i][0] * boxTypes[i][1]);
                truckSize = truckSize - boxTypes[i][0];
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
