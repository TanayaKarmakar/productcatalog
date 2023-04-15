package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 13/04/23
 * @project ds-algo-2021-leetcode
 */
public class FindRightIntervalLeetcode436 {
  static class IntervalItem implements Comparable<IntervalItem> {
    int indx;
    int[] interval;

    public IntervalItem(int indx, int[] interval) {
      this.indx = indx;
      this.interval = interval;
    }

    @Override
    public int compareTo(IntervalItem o) {
      return this.interval[0] - o.interval[0];
    }
  }

  private static int[] findRightInterval(int[][] intervals) {
    if(intervals.length == 1)
      return new int[]{-1};
    int n = intervals.length;
    IntervalItem[] intervalItems = new IntervalItem[n];
    for(int i = 0; i < n; i++) {
      intervalItems[i] = new IntervalItem(i, intervals[i]);
    }

    Arrays.sort(intervalItems);

    int[] result = new int[n];
    Arrays.fill(result, -1);
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        if(intervalItems[i].interval[1] <= intervalItems[j].interval[0]) {
          result[intervalItems[i].indx] = intervalItems[j].indx;
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1,4},{2,3},{3,4}};

    int[] result = findRightInterval(intervals);

    System.out.println(Arrays.toString(result));
  }
}
