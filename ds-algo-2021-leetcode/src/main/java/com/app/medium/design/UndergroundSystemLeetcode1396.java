package com.app.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author t0k02w6 on 06/05/23
 * @project ds-algo-2021-leetcode
 */

class UndergroundSystem {
  static class RouteItem {
    String routeName;
    int timeStamp;

    public RouteItem(String routeName, int timeStamp) {
      this.routeName = routeName;
      this.timeStamp = timeStamp;
    }
  }

  private Map<Integer, Stack<RouteItem>> passengerRouteMap;
  private Map<String, List<Integer>> routeTimeMap;

  public UndergroundSystem() {
    this.passengerRouteMap = new HashMap<>();
    this.routeTimeMap = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    if(!passengerRouteMap.containsKey(id)) {
      passengerRouteMap.put(id, new Stack<>());
    }
    passengerRouteMap.get(id).push(new RouteItem(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    RouteItem sourceItem = passengerRouteMap.get(id).pop();
    int timeDiff = (t - sourceItem.timeStamp);
    String routeKey = sourceItem.routeName + ":" + stationName;
    if(!routeTimeMap.containsKey(routeKey))
      routeTimeMap.put(routeKey, new ArrayList<>());
    routeTimeMap.get(routeKey).add(timeDiff);
  }

  public double getAverageTime(String startStation, String endStation) {
    String routeKey = startStation + ":" + endStation;

    if(!routeTimeMap.containsKey(routeKey))
      return 0.0;
    List<Integer> totalTimeDiffs = routeTimeMap.get(routeKey);
    double totalTime = 0;
    for(Integer el: totalTimeDiffs) {
      totalTime += el;
    }

    return totalTime / (double) totalTimeDiffs.size();
  }
}


public class UndergroundSystemLeetcode1396 {
}
