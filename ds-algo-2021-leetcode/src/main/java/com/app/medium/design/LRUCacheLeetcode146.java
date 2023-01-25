package com.app.medium.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 25/01/23
 * @project ds-algo-2021
 */
class LRUCache {
  Map<Integer, Item> map;
  Deque<Item> itemQ;
  int maxCap;
  int currentCap;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    this.itemQ = new LinkedList<>();
    this.maxCap = capacity;
    this.currentCap = 0;
  }

  public int get(int key) {
    if(map.containsKey(key)) {
      Item item = map.get(key);
      itemQ.remove(item);
      itemQ.addFirst(item);
    }
    return -1;
  }

  public void put(int key, int value) {
    if(map.containsKey(key)) {
      Item valueItem = map.get(key);
      itemQ.remove(valueItem);

      valueItem.value = value;
      map.put(key, valueItem);
      itemQ.addFirst(valueItem);
    } else {
      Item newItem = new Item(key, value);
      if(currentCap == maxCap) {
        Item leastUsed = itemQ.pollLast();
        map.remove(leastUsed.key);
        currentCap--;
      }
      map.put(key, newItem);
      itemQ.addFirst(newItem);
      currentCap++;
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



public class LRUCacheLeetcode146 {
  public static void main(String[] args) {

  }
}
