package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
class SnapshotArray {
    Map<Integer, Integer> map;
    int size;
    List<Map<Integer, Integer>> snapList;


    public SnapshotArray(int length) {
        map = new HashMap<>();
        snapList = new ArrayList<>();
        //currentSnap = 0;
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
