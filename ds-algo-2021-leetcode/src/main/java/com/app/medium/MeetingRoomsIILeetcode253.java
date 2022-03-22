package com.app.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
class ValueComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
        //return o1[0] - o2[0];
    }
}

public class MeetingRoomsIILeetcode253 {
    private static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        PriorityQueue<int[]> pQ = new PriorityQueue<>(new ValueComparator());

        for(int i = 0; i < intervals.length; i++) {
            if(pQ.isEmpty()) {
                pQ.add(intervals[i]);
            } else {
                if(pQ.peek()[1] <= intervals[i][0]) {
                    int[] curr = pQ.poll();
                    curr[1] = intervals[i][1];
                    pQ.add(curr);
                } else {
                    pQ.add(intervals[i]);
                }
            }
        }
        return pQ.size();
    }

    public static void main(String[] args) {

    }
}
