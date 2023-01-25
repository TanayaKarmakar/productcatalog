package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author t0k02w6 on 25/01/23
 * @project ds-algo-2021
 */
public class MergeIntervalsLeetcode56 {
  private static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

    List<int[]> intermediateResult = new ArrayList<>();
    int start = intervals[0][0];
    int end = intervals[0][1];

    for(int i = 1; i < intervals.length; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];

      if(currentStart <= end) {
        start = Integer.min(start, currentStart);
        end = Integer.max(end, currentEnd);
      } else {
        intermediateResult.add(new int[] {start, end});
        start = currentStart;
        end = currentEnd;
      }
    }
    intermediateResult.add(new int[]{start, end});
    int[][] result = new int[intermediateResult.size()][];
    int i = 0;
    for(int[] current: intermediateResult) {
      result[i++] = current;
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    int[][] result = merge(intervals);

    for(int[] curr: result) {
      System.out.println(Arrays.toString(curr));
    }
  }
}
