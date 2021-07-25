package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 25/07/21
 * @project ds-algo-2021
 */
public class MaximumUnitsInATruckLeetcode1710 {
    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (e1, e2) -> e2[1] - e1[1]);

        int total = 0;
        int i = 0;
        while(i < boxTypes.length && truckSize > 0) {
            int[] curr = boxTypes[i];
            if(curr[0] < truckSize) {
                total += (curr[0] * curr[1]);
                truckSize -= curr[0];
            } else {
                total += (truckSize * curr[1]);
                truckSize = 0;
            }
            i++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;

        int ans = maximumUnits(boxTypes, truckSize);
        System.out.println(ans);
    }
}
