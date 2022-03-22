package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class MergeIntervalsLeetcode56 {
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> result = new ArrayList<>();
        int prevStart = -1;
        int prevEnd = -1;
        for(int i = 0; i < intervals.length; i++) {
            if(prevStart == -1) {
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            } else {
                if(intervals[i][0] <= prevEnd) {
                    prevStart = Integer.min(prevStart, intervals[i][0]);
                    prevEnd = Integer.max(prevEnd, intervals[i][1]);
                } else {
                    result.add(new int[]{prevStart, prevEnd});
                    prevStart = intervals[i][0];
                    prevEnd = intervals[i][1];
                }
            }
        }
        result.add(new int[]{prevStart, prevEnd});
        int[][] finalResult = new int[result.size()][2];

        int i = 0;
        for(int[] currPair: result) {
            finalResult[i++] = currPair;
        }
        return finalResult;
    }

    public static void main(String[] args) {

    }
}
