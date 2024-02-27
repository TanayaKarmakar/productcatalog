package com.app.medium.design;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    static class Item {
        String value;
        int timestamp;

        public Item(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Item>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Item(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Item> valueItems = map.getOrDefault(key, new ArrayList<>());
        if(valueItems.isEmpty())
            return "";
        int start = 0;
        int end = valueItems.size() - 1;

        int finalAns = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            Item item = valueItems.get(mid);

            if(item.timestamp == timestamp)
                return valueItems.get(mid).value;
            else if(item.timestamp > timestamp) {
                end = mid - 1;
            } else {
                finalAns = mid;
                start = mid + 1;
            }

        }
        if(finalAns == -1)
            return "";
        return valueItems.get(finalAns).value;
    }
}
public class TimeBasedKeyValueStoreLeetcode981 {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo","bar", 1);

        System.out.println(timeMap.get("foo", 1));
    }
}
