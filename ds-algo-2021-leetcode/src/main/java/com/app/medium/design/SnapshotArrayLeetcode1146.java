package com.app.medium.design;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SnapshotArray {
    Map<Integer, Integer> map;
    List<Map<Integer, Integer>> snapList;

    public SnapshotArray(int length) {
        map = new HashMap<>();
        snapList = new ArrayList<>();
    }

    public void set(int index, int val) {
        map.put(index, val);
    }

    public int snap() {
        Map<Integer, Integer> newMap = new HashMap<>(map);
        snapList.add(newMap);
        return snapList.size() - 1;
    }

    public int get(int index, int snap_id) {
        return snapList.get(snap_id).getOrDefault(index, 0);
    }
}

public class SnapshotArrayLeetcode1146 {
    public static void main(String[] args) {

    }
}
