package com.app.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIILeetcode253 {
    static class Item {
        int start;
        int end;

        public Item(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int minMeetingRooms(int[][] intervals) {
       PriorityQueue<Item> pQ = new PriorityQueue<>((i1, i2) -> i1.end - i2.end);

       Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

       pQ.add(new Item(intervals[0][0], intervals[0][1]));

       for(int i = 1; i < intervals.length; i++) {
           int[] current = intervals[i];
           if(pQ.peek().end <= current[0]) {
               Item pQItem = pQ.poll();
               pQItem.end = current[1];
               pQ.add(pQItem);
           } else {
               pQ.add(new Item(current[0], current[1]));
           }
       }
       return pQ.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};

        int ans = minMeetingRooms(intervals);

        System.out.println(ans);

        intervals = new int[][]{{7,10},{2,4}};
        ans = minMeetingRooms(intervals);

        System.out.println(ans);
    }
}
