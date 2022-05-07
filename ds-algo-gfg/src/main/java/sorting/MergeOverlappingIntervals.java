package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 05/05/22
 * @project ds-algo-2021
 */
public class MergeOverlappingIntervals {
    private static List<int[]> mergeIntervals(int[][] intervals) {
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
                    prevStart = Integer.min(intervals[i][0], prevStart);
                    prevEnd = Integer.max(intervals[i][1], prevEnd);
                } else {
                    result.add(new int[]{prevStart, prevEnd});
                    prevStart = intervals[i][0];
                    prevEnd = intervals[i][1];
                }
            }
        }
        result.add(new int[] {prevStart, prevEnd});
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{7,9},{6,10},{4,5},{1,3},{2,4}};

        List<int[]> result = mergeIntervals(intervals);

        for(int[] curr: result) {
            System.out.println(Arrays.toString(curr));
        }
    }
}
