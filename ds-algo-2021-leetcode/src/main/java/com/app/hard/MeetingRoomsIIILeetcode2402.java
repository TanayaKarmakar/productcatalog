package com.app.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 06/05/23
 * @project ds-algo-2021-leetcode
 */
public class MeetingRoomsIIILeetcode2402 {
  static class BookItem implements Comparable<BookItem> {
    int roomNumber;
    int endTs;

    public BookItem(int roomNumber, int endTs) {
      this.roomNumber = roomNumber;
      this.endTs = endTs;
    }

    @Override
    public int compareTo(BookItem o) {
      if(this.endTs == o.endTs)
        return this.roomNumber - o.roomNumber;
      return this.endTs - o.endTs;
    }
  }

  private static int mostBooked(int n, int[][] meetings) {
    PriorityQueue<Integer> availPQ = new PriorityQueue<>();
    for(int i = 0; i < n; i++) {
      availPQ.add(i);
    }

    PriorityQueue<BookItem> bookingPQ = new PriorityQueue<>();
    TreeMap<Integer, Integer> meetingFreqMap = new TreeMap<>();
    Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);

    for(int i = 0; i < meetings.length; i++) {
      if(bookingPQ.isEmpty() || !availPQ.isEmpty()) {
        int roomNumber = availPQ.poll();
        bookingPQ.add(new BookItem(roomNumber, meetings[i][1]));
        meetingFreqMap.put(roomNumber, meetingFreqMap.getOrDefault(roomNumber, 0) + 1);
      } else if(availPQ.isEmpty()) {
        if(bookingPQ.peek().endTs > meetings[i][0]) {
          BookItem bookItem = bookingPQ.poll();
          int timeDurationForCurrentMeeting = meetings[i][1] - meetings[i][0];
          bookItem.endTs = bookItem.endTs + timeDurationForCurrentMeeting;
          bookingPQ.add(bookItem);
          meetingFreqMap.put(bookItem.roomNumber, meetingFreqMap.getOrDefault(bookItem.roomNumber, 0) + 1);
        } else {
          List<BookItem> poppedRoomNumbers = new ArrayList<>();

          while(!bookingPQ.isEmpty()) {
            BookItem currentBookItem = bookingPQ.poll();
            if(currentBookItem.endTs < meetings[i][1]) {
              availPQ.add(currentBookItem.roomNumber);
            } else {
              poppedRoomNumbers.add(currentBookItem);
            }
          }

          int roomNumber = availPQ.poll();

          bookingPQ.add(new BookItem(roomNumber, meetings[i][1]));
          bookingPQ.addAll(poppedRoomNumbers);
          meetingFreqMap.put(roomNumber, meetingFreqMap.getOrDefault(roomNumber, 0) + 1);
        }
      }
    }

    int maxNumberOfMeetings = 0;
    int resultRoom = 0;
    for(int i = 0; i < n; i++) {
      int meetingsInCurrentRoom = meetingFreqMap.getOrDefault(i, 0);
      if(meetingsInCurrentRoom > maxNumberOfMeetings) {
        maxNumberOfMeetings = meetingsInCurrentRoom;
        resultRoom = i;
      }
    }
    return resultRoom;
  }

  public static void main(String[] args) {
//    int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
//    int n = 2;
//    int ans = mostBooked(n, meetings);
//
//    System.out.println(ans);
//
//    meetings = new int[][] {{1,20},{2,10},{3,5},{4,9},{6,8}};
//    n = 3;
//    ans = mostBooked(n, meetings);
//
//    System.out.println(ans);

    int[][] meetings = {{0,10},{1,5},{2,7},{3,4},{8,11},{9,12}};
    int n = 2;

    int ans = mostBooked(n, meetings);

    System.out.println(ans);
  }
}
