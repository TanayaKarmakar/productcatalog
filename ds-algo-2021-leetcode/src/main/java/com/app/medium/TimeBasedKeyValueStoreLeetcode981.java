package com.app.medium;

import com.app.common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
 */

class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair<String, Integer> pair = new Pair<>(value, timestamp);
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(pair);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Pair<String, Integer>> values = map.get(key);

        int start = 0;
        int end = values.size() - 1;
        int ans = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            Pair<String, Integer> midPair = values.get(mid);
            if( midPair.second == timestamp)
                return midPair.first;
            else if(midPair.second > timestamp)
                end = mid - 1;
            else {
                ans = start;
                start = mid + 1;
            }
        }

        return ans == -1 ? "": values.get(ans).first;
    }
}

public class TimeBasedKeyValueStoreLeetcode981 {
    public static void main(String[] args) {

    }
}
