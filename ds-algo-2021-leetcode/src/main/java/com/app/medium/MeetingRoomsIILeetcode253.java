package com.app.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 06/10/21
 * @project ds-algo-2021
 */



public class MeetingRoomsIILeetcode253 {
    private static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        for(int i = 0; i < intervals.length; i++) {
            if(pQ.isEmpty() || pQ.peek()[1] > intervals[i][0])
                pQ.add(intervals[i]);
            else {
                int[] existing = pQ.poll();
                existing[1] = intervals[i][1];
                pQ.add(existing);

            }
        }
        return pQ.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{5, 8},{6, 8}};
        int ans = minMeetingRooms(intervals);

        System.out.println(ans);
    }
}
