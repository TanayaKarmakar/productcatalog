package com.app.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 08/04/23
 * @project ds-algo-2021-leetcode
 */

class FirstUnique {
  Map<Integer, Item> map;
  Queue<Item> q;

  public FirstUnique(int[] nums) {
    map = new HashMap<>();
    q = new LinkedList<>();
    for(int i = 0; i < nums.length; i++) {
      if(!map.containsKey(nums[i])) {
        Item newItem = new Item(nums[i], 1);
        map.put(nums[i], newItem);
        q.add(newItem);
      } else {
        Item item = map.get(nums[i]);
        q.remove(item);
        item.value = item.value + 1;
        map.put(nums[i], item);
      }
    }
  }

  public int showFirstUnique() {
    if(!q.isEmpty())
      return q.peek().key;
    return -1;
  }

  public void add(int value) {
    if(!map.containsKey(value)) {
      Item newItem = new Item(value, 1);
      map.put(value, newItem);
      q.add(newItem);
    } else {
      Item item = map.get(value);
      q.remove(item);
      item.value = item.value + 1;
      map.put(value, item);
    }
  }

  static class Item {
    int key;
    int value;

    public Item(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}

public class FirstUniqueNumberLeetcode1429 {

  public static void main(String[] args) {

  }
}
