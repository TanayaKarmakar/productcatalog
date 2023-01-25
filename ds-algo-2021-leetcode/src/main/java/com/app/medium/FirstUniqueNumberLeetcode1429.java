package com.app.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 06/12/22
 * @project ds-algo-2021
 */

class FirstUnique {
  Map<Integer, Integer> map;
  Queue<Integer> queue;

  public FirstUnique(int[] nums) {
    map = new HashMap<>();
    queue = new LinkedList<>();
    for(int el: nums) {
      if(!map.containsKey(el)) {
        map.put(el, 1);
        queue.add(el);
      } else {
        map.put(el, map.getOrDefault(el, 0) + 1);
        queue.remove(el);
      }
    }
  }

  public int showFirstUnique() {
    if(queue.isEmpty())
      return -1;
    return queue.peek();
  }

  public void add(int value) {
    if(!map.containsKey(value)) {
      map.put(value, 1);
      queue.add(value);
    } else {
      map.put(value, map.getOrDefault(value, 0) + 1);
      queue.remove(value);
    }
  }
}

public class FirstUniqueNumberLeetcode1429 {
}
