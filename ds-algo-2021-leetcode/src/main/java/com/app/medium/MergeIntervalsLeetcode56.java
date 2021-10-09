package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author t0k02w6 on 06/10/21
 * @project ds-algo-2021
 */
public class MergeIntervalsLeetcode56 {
    private static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        List<int[]> out = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(currentStart > prevEnd) {
                out.add(new int[]{prevStart, prevEnd});
                prevStart = currentStart;
                prevEnd = currentEnd;
            } else {
                prevEnd = Integer.max(currentEnd, prevEnd);
            }
        }

        int[][] result = new int[out.size() + 1][2];
        for(int i = 0; i < out.size(); i++) {
            result[i] = out.get(i);
        }
        result[out.size()] = new int[]{prevStart, prevEnd};

        return result;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int[][] res = merge(intervals);
        for(int[] val: res) {
            System.out.println(Arrays.toString(val));
        }
    }
}
