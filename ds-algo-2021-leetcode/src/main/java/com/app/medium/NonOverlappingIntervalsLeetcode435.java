package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/10/22
 * @project ds-algo-2021-leetcode
 */
public class NonOverlappingIntervalsLeetcode435 {
  private static int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (e1, e2) -> {
      if(e1[0] == e2[0])
        return e1[1] - e2[1];
      return e1[0] - e2[0];
    });

    int prevStart = intervals[0][0];
    int prevEnd = intervals[0][1];

    int count = 0;
    for(int i = 1; i < intervals.length; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];
      if(currentStart >= prevEnd && currentStart > prevStart && currentEnd > prevEnd) {
        prevStart = currentStart;
        prevEnd = currentEnd;
      } else {
        if(prevStart <= currentStart && prevEnd >= currentEnd) {
          prevStart = currentStart;
          prevEnd = currentEnd;
        }
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
    int ans = eraseOverlapIntervals(intervals);

    System.out.println(ans);
  }
}
