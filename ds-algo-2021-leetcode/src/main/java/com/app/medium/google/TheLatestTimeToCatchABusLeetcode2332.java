package com.app.medium.google;

import java.util.Arrays;

/**
 * @author t0k02w6 on 11/07/23
 * @project ds-algo-2021-leetcode
 */
public class TheLatestTimeToCatchABusLeetcode2332 {
  private static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
    Arrays.sort(buses);
    Arrays.sort(passengers);

    if(passengers[0] > buses[buses.length - 1])
      return buses[buses.length - 1];
    int result = passengers[0] - 1;
    int i = 0;
    int j = 0;
    while(i < buses.length) {
      int occupiedSeats = 0;
      while(occupiedSeats < capacity && j < passengers.length && passengers[j] <= buses[i]) {
        if(j > 0 && passengers[j] - passengers[j - 1] != 1) {
          result = passengers[j] - 1;
        }
        occupiedSeats++;
        j++;
      }

      if(j > 0 && occupiedSeats < capacity && buses[i] != passengers[j - 1]) {
        result = buses[i];
      }
      i++;
    }
    return result;

//    int start = 0;
//    int end = passengers.length - 1;
//
//    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//    for(int i = 0; i < n; i++) {
//      int currentBusTiming = buses[i];
//      int floorIndx = getFloor(passengers, start, end, currentBusTiming);
//      if(floorIndx - start + 1 > capacity) {
//        floorIndx = start + capacity - 1;
//      }
//      List<Integer> passengerList = new ArrayList<>();
//      for(int j = start; j <= floorIndx; j++) {
//        passengerList.add(passengers[j]);
//      }
//      map.put(currentBusTiming, passengerList);
//      start = floorIndx + 1;
//    }
//
//    if(n == 1) {
//      List<Integer> passengerList = map.get(buses[0]);
//      if(passengerList.size() < capacity) {
//        int lastPassenger = passengerList.get(passengerList.size() - 1);
//        return lastPassenger + 1;
//      } else {
//        for(int j = passengerList.size() - 2; j >= 0; j--) {
//          if(passengerList.get(j + 1) - passengerList.get(j) > 1)
//            return passengerList.get(j) + 1;
//        }
//        return passengerList.get(0) - 1;
//      }
//    }
//
//    for(int i = n - 1; i >= 0; i--) {
//      List<Integer> passengerList = map.get(buses[i]);
//      if(i == 0) {
//        if(passengerList.size() < capacity) {
//          List<Integer> nextPassengerList = map.get(buses[i + 1]);
//          int lastPassengerOfCurrentBus = passengerList.get(passengerList.size() - 1);
//          int firstPassengerOfNextBus = nextPassengerList.get(0);
//          if(firstPassengerOfNextBus - lastPassengerOfCurrentBus > 1)
//            return lastPassengerOfCurrentBus + 1;
//          else {
//            for(int j = passengerList.size() - 2; j >= 0; j--) {
//              if(passengerList.get(j + 1) - passengerList.get(j) > 1)
//                return passengerList.get(j) + 1;
//            }
//            return passengerList.get(0) - 1;
//          }
//        }
//      }
//      else if(i < (n - 1)) {
//        if(passengerList.size() < capacity) {
//          List<Integer> previousPassengerList = map.get(buses[i - 1]);
//          List<Integer> nextPassengerList = map.get(buses[i + 1]);
//          int lastPassengerOfCurrentBus = passengerList.get(passengerList.size() - 1);
//          int firstPassengerOfNextBus = nextPassengerList.get(0);
//          if(firstPassengerOfNextBus - lastPassengerOfCurrentBus > 1)
//            return lastPassengerOfCurrentBus + 1;
//          else {
//            for(int j = passengerList.size() - 2; j >= 0; j--) {
//              if(passengerList.get(j + 1) - passengerList.get(j) > 1)
//                return passengerList.get(j) + 1;
//            }
//            int lastPassengerFromPreviousBus = previousPassengerList.get(previousPassengerList.size() - 1);
//            if(passengerList.get(0) - lastPassengerFromPreviousBus > 1)
//              return passengerList.get(0) - 1;
//          }
//        }
//      } else {
//        if(passengerList.size() < capacity) {
//          int lastEntry = passengerList.get(passengerList.size() - 1);
//          return lastEntry + 1;
//        } else {
//          for(int j = passengerList.size() - 2; j >= 0; j--) {
//            if(passengerList.get(j + 1) - passengerList.get(j) > 1)
//              return passengerList.get(j) + 1;
//          }
//          List<Integer> previousBusPassengerList = map.get(buses[i - 1]);
//          if(passengerList.get(0) - previousBusPassengerList.get(previousBusPassengerList.size() - 1) > 1)
//            return passengerList.get(0) -1;
//        }
//      }
//    }
//    return -1;
  }

//  private static int getFloor(int[] passengers, int start, int end, int currentBusTiming) {
//    int floorIndx = -1;
//    while(start <= end) {
//      int mid = (start + end) >> 1;
//      if(passengers[mid] == currentBusTiming)
//        return mid;
//      else if(passengers[mid] > currentBusTiming) {
//        end = mid - 1;
//      } else {
//        floorIndx = mid;
//        start = mid + 1;
//      }
//    }
//    return floorIndx;
//  }

  public static void main(String[] args) {
    int[] buses = {10,20};
    int[] passengers = {2,17,18,19};
    int capacity = 2;
    int ans = latestTimeCatchTheBus(buses, passengers, capacity);

    System.out.println(ans);

    buses = new int[] {20,30,10};
    passengers = new int[]{19,13,26,4,25,11,21};
    capacity = 2;
    ans = latestTimeCatchTheBus(buses, passengers, capacity);

    System.out.println(ans);
  }
}
