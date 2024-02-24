package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsLeetcode56 {
    private static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if(currentStart <= prevEnd) {
                prevStart = Integer.min(currentStart, prevStart);
                prevEnd = Integer.max(currentEnd, prevEnd);
            } else {
                list.add(new int[]{prevStart, prevEnd});
                prevStart = currentStart;
                prevEnd = currentEnd;
            }
        }
        list.add(new int[]{prevStart, prevEnd});

        int[][] result = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);

        for(int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
