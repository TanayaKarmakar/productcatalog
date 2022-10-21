package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 26/09/22
 * @project ds-algo-2021-leetcode
 */
class SnapshotArray {
    List<Map<Integer, Integer>> list;
    Map<Integer, Integer> map;
    int spanCount;
    public SnapshotArray(int length) {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public void set(int index, int val) {
        map.put(index, val);
    }

    public int snap() {
        Map<Integer, Integer> newHashMap = new HashMap<>(map);
        list.add(newHashMap);
        return list.size() - 1;
    }

    public int get(int index, int snap_id) {
        return list.get(snap_id).getOrDefault(index, 0);
    }
}



public class SnapshotArrayLeetcode1146 {
    public static void main(String[] args) {

    }
}
