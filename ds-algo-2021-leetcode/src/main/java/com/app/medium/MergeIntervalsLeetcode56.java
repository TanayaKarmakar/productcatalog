package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class MergeIntervalsLeetcode56 {
    private static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> intervalList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if(currentStart < end) {
                start = Integer.min(currentStart, start);
                end = Integer.max(currentEnd, end);
            } else {
                intervalList.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }

        intervalList.add(new int[]{start, end});


        int[][] result = new int[intervalList.size()][];
        int i = 0;
        for(int[] currentInterval: intervalList) {
            result[i++] = currentInterval;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
