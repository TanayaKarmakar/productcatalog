package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 26/04/23
 * @project ds-algo-2021-leetcode
 */

class TimeMap {
  static class Item {
    String value;
    int ts;

    public Item(String value, int ts) {
      this.value = value;
      this.ts = ts;
    }
  }

  Map<String, List<Item>> map;

  public TimeMap() {
    this.map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if(!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
    map.get(key).add(new Item(value, timestamp));
  }

  public String get(String key, int timestamp) {
    List<Item> items = map.getOrDefault(key, new ArrayList<>());
    if(!items.isEmpty()) {
      if(items.size() == 1 && items.get(0).ts <= timestamp) {
        return items.get(0).value;
      } else {
        int start = 0;
        int end = items.size() - 1;
        int finalAns = -1;
        while(start <= end) {
          int mid = (start + end) >> 1;
          if(items.get(mid).ts > timestamp) {
            end = mid - 1;
          } else {
            finalAns = mid;
            start = mid + 1;
          }
        }
        if(finalAns == -1)
          return "";
        return items.get(finalAns).value;
      }
    }
    return "";
  }
}

public class TimeBasedKeyValueStoreLeetcode981 {
  public static void main(String[] args) {
    TimeMap timeMap = new TimeMap();
    timeMap.set("love", "high", 10);
    timeMap.set("love", "low", 20);
    System.out.println(timeMap.get("love", 5));
    System.out.println(timeMap.get("love", 10));
    System.out.println(timeMap.get("love", 15));
    System.out.println(timeMap.get("love", 20));
    System.out.println(timeMap.get("love", 25));
//    timeMap.set("foo", "bar2", 4);
//    System.out.println(timeMap.get("foo", 4));
//    System.out.println(timeMap.get("foo", 5));
  }
}
