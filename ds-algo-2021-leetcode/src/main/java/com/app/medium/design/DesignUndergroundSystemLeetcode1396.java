package com.app.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 19/06/23
 * @project ds-algo-2021-leetcode
 */

class UndergroundSystem {
  private Map<Integer, TravelInfo> passengerMap;
  private Map<String, List<Double>> travelTimeMap;

  public UndergroundSystem() {
    passengerMap = new HashMap<>();
    travelTimeMap = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    passengerMap.put(id, new TravelInfo(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    TravelInfo travelInfo = passengerMap.get(id);
    String key = travelInfo.getStationName() + ":" + stationName;
    if(!travelTimeMap.containsKey(key)) {
      travelTimeMap.put(key, new ArrayList<>());
    }
    travelTimeMap.get(key).add((double)(t - travelInfo.getTs()));
  }

  public double getAverageTime(String startStation, String endStation) {
    String key = startStation + ":" + endStation;
    List<Double> times = travelTimeMap.get(key);
    double sum = 0;
    for(double time: times) {
      sum += time;
    }
    return sum / times.size();
  }

  static class TravelInfo {
    private String stationName;
    private int ts;

    public TravelInfo(String stationName, int ts) {
      this.stationName = stationName;
      this.ts = ts;
    }

    public String getStationName() {
      return stationName;
    }

    public int getTs() {
      return ts;
    }
  }
}

public class DesignUndergroundSystemLeetcode1396 {
  public static void main(String[] args) {

  }
}
