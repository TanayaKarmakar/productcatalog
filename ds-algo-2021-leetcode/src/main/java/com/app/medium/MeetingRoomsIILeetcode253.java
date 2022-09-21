package com.app.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 18/09/22
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
        pQ.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if(currentInterval[0] >= pQ.peek()[1]) {
                int[] item = pQ.poll();
                item[1] = currentInterval[1];
                pQ.add(item);
            } else {
                pQ.add(currentInterval);
            }
        }
        return pQ.size();
    }

    public static void main(String[] args) {

    }
}
