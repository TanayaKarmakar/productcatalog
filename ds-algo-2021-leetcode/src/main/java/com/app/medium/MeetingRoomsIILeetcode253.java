package com.app.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */

class FinishTimeComparator implements Comparator<int[]> {

  @Override
  public int compare(int[] o1, int[] o2) {
    return o1[1] - o2[1];
  }
}

public class MeetingRoomsIILeetcode253 {
  private static int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

    PriorityQueue<int[]> pQ = new PriorityQueue<>(new FinishTimeComparator());

    for(int[] interval: intervals) {
      if(pQ.isEmpty() || pQ.peek()[1] > interval[0]) {
        pQ.add(interval);
      } else {
        int[] topInterval = pQ.poll();
        topInterval[1] = interval[1];
        pQ.add(topInterval);
      }
    }

    return pQ.size();
  }

  public static void main(String[] args) {
    int[][] intervals = {{0,30},{5,10},{15, 20}};

    int ans = minMeetingRooms(intervals);

    System.out.println(ans);
  }
}
