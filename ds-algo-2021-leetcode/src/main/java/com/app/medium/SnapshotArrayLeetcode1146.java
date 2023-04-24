package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */

class SnapshotArray {
  Map<Integer, Integer> map;
  List<Map<Integer, Integer>> list;

  public SnapshotArray(int length) {
    this.map = new HashMap<>();
    this.list = new ArrayList<>();
  }

  public void set(int index, int val) {
    map.put(index, val);
  }

  public int snap() {
    Map<Integer, Integer> newMap = new HashMap<>(map);
    list.add(newMap);
    return list.size() - 1;
  }

  public int get(int index, int snap_id) {
    return list.get(snap_id).getOrDefault(index, 0);
  }
}

public class SnapshotArrayLeetcode1146 {
  public static void main(String[] args) {
    SnapshotArray obj = new SnapshotArray(3);
    obj.set(0, 5);
    System.out.println(obj.snap());
    obj.set(0, 6);
    System.out.println(obj.get(0, 0));
  }
}
