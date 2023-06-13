package com.app.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */
public class MeetingRoomsIILeetcode253 {
  static class FinishTimeComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
      return o1[1] - o2[1];
    }
  }


  private static int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
    PriorityQueue<int[]> pQ = new PriorityQueue<>(new FinishTimeComparator());
    for(int i = 0; i < intervals.length; i++) {
      if(pQ.isEmpty() || pQ.peek()[1] > intervals[i][0]) {
        pQ.add(intervals[i]);
      } else {
        int[] item = pQ.poll();
        item[1] = intervals[i][1];
        pQ.add(item);
      }
    }
    return pQ.size();
  }

  public static void main(String[] args) {

  }
}
