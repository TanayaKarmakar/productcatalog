package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class FindTheRightIntervalLeetcode436 {
  static class IntervalItem {
    int[] interval;
    int indx;

    public IntervalItem(int[] interval, int indx) {
      this.interval = interval;
      this.indx = indx;
    }
  }

  private static int[] findRightInterval(int[][] intervals) {
    int n = intervals.length;
    IntervalItem[] intervalItems = new IntervalItem[n];
    for(int i = 0; i < n; i++) {
      intervalItems[i] = new IntervalItem(intervals[i], i);
    }

    Arrays.sort(intervalItems, (i1, i2) -> i1.interval[0] - i2.interval[0]);
    int[] result = new int[n];
    Arrays.fill(result, -1);

    IntervalItem lastIntervalItem = intervalItems[n - 1];
    result[lastIntervalItem.indx] = -1;

    for(int i = 0; i < (n - 1); i++) {
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
    int[][] intervals = {{3,4},{2,3},{1,2}};
    int[] result = findRightInterval(intervals);

    System.out.println(Arrays.toString(result));
  }
}
