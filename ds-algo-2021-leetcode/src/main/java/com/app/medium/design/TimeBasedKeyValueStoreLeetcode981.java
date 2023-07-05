package com.app.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 15/06/23
 * @project ds-algo-2021-leetcode
 */

class TimeMap {

  static class ValueItem {
    String value;
    int timestamp;

    public ValueItem(String value, int timestamp) {
      this.value = value;
      this.timestamp = timestamp;
    }
  }

  Map<String, List<ValueItem>> valueMap;

  public TimeMap() {
    valueMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if(!valueMap.containsKey(key)) {
      valueMap.put(key, new ArrayList<>());
    }
    valueMap.get(key).add(new ValueItem(value, timestamp));
  }

  public String get(String key, int timestamp) {
    List<ValueItem> valueItems = valueMap.getOrDefault(key, new ArrayList<>());
    if(!valueItems.isEmpty()) {
      int start = 0;
      int end = valueItems.size() - 1;
      int finalAns = -1;
      while(start <= end) {
        int mid = (start + end) >> 1;
        if(valueItems.get(mid).timestamp == timestamp)
          return valueItems.get(mid).value;
        else if(valueItems.get(mid).timestamp > timestamp) {
          end = mid - 1;
        } else {
          finalAns = mid;
          start = mid + 1;
        }
      }

      if(finalAns != -1)
        return "";
      return valueItems.get(finalAns).value;
    }
    return "";
  }
}

public class TimeBasedKeyValueStoreLeetcode981 {
  public static void main(String[] args) {

  }
}
