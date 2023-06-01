package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class MergeIntervalsLeetcode56 {
  private static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

    int start = intervals[0][0];
    int end = intervals[0][1];

    List<int[]> result = new ArrayList<>();
    for(int i = 1; i < intervals.length; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];
      if(currentStart <= end) {
        start = Integer.min(start, currentStart);
        end = Integer.max(end, currentEnd);
      } else {
        result.add(new int[]{start, end});
        start = currentStart;
        end = currentEnd;
      }
    }

    result.add(new int[]{start, end});
    int[][] finalResult = new int[result.size()][];
    for(int i = 0; i < result.size(); i++) {
      finalResult[i] = result.get(i);
    }

    return finalResult;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    int[][] finalResult = merge(intervals);

    for(int i = 0; i < finalResult.length; i++) {
      System.out.println(Arrays.toString(finalResult[i]));
    }
  }
}
